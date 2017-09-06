import Image
import serial  
import sklearn as sk
from sklearn import metrics
from sklearn import svm
import numpy as np
import matplotlib.pyplot as plt
import seaborn as sns
from scipy.misc import imread
import pandas as pd
from sklearn.svm import SVC
from scipy.stats import sem
from textblob.classifiers import NaiveBayesClassifier
import urllib2
import re
import time


data_training = pd.read_csv('feelingparameters.csv')
predicted = pd.read_csv('currentdata.csv')
prediction = pd.read_csv('predictdata.csv')

def webdata():

    response = urllib2.urlopen("https://www.worldweatheronline.com/nanjing-weather-text/jiangsu/cn.aspx")
    page = response.read()
    pattern1_0 = re.compile(r'The weather is forecasted to be ..........................................')
    pattern1_1 = re.compile(r'rain')
    pattern1_2 = re.compile(r'mist')
    pattern1_3 = re.compile(r'cloudy')
    pattern1_4 = re.compile(r'sunny')
    pattern1_5 = re.compile(r'clear')
    pattern1_6 = re.compile(r'drizzle')

    pattern2_0 = re.compile(r'The daytime temperature is going to reach ..............................')
    pattern2_1 = re.compile(r'\d+')

    pattern3_0 = re.compile(r'the temperature is going to dip to ..............................')
    pattern3_1 = re.compile(r'\d+')

    pattern4_0 = re.compile(r'the humidity will be around ..............................')
    pattern4_1 = re.compile(r'\d+')
    result1_0 = re.findall(pattern1_0, page)
    result2_0 = re.findall(pattern2_0, page)
    result3_0 = re.findall(pattern3_0, page)
    result4_0 = re.findall(pattern4_0, page)
    
#judge rain,mist,drizzle,cloudy,sunny,clear   
    result1_1 = re.findall(pattern1_1,result1_0 [0])
    result1_2 = re.findall(pattern1_2,result1_0 [0])
    result1_3 = re.findall(pattern1_3,result1_0 [0])
    result1_4 = re.findall(pattern1_4,result1_0 [0])
    result1_5 = re.findall(pattern1_5,result1_0 [0])
    result1_6 = re.findall(pattern1_6,result1_0 [0])
    if len(result1_1) != 0 or len(result1_6) != 0:
        predicted.weather = -1
        print("current weather is rainy")
    
    if len(result1_2) != 0 or len(result1_3) != 0:
        predicted.weather = 0
        print("current weather is cloudy")
    
    if len(result1_4) != 0 or len(result1_5) != 0:
        predicted.weather = 1
        print("current weather is sunny")
    
#get the daytime temperature     
    result2_1 = re.findall(pattern2_1,result2_0[0])
    
    if '15'<=result2_1 <='26':
        predicted.temperature = 1
        print("daytime.temperature is "+ result2_1[0])
        
    if result2_1 <= '10' or result2_1 >= '34':
        predicted.temperature = -1
        print("daytime.temperature is "+ result2_1[0])
        
    if '10'<result2_1 < '15' or '26'<result2_1 < '33':
        predicted.temperature = 0
        print("daytime.temperature is "+ result2_1[0])
    
#get the night temperature 

    result3_1 = re.findall(pattern3_1,result3_0[0])
    
    if '15'<=result2_1 <='26':
        #predicted.temperature = 1
        print("night.temperature is  %c" % result3_1[0])
        
    if result2_1 <= '10' or result2_1 >= '34':
        #predicted.temperature = -1
        print("night.temperature is "+ result3_1[0])
        
    if '10'<result2_1 < '15' or '26'<result2_1 < '33':
        #predicted.temperature = 0
        print("night.temperature is "+ result3_1[0])
    
#get the humidity

    result4_1 = re.findall(pattern4_1,result4_0[0])
    if '30'<=result4_1 <='40':
        predicted.humidity = 1
        print("humidity is  "+  result4_1[0] +"%")
            
    if result4_1 <= '10' or result4_1 >= '60':
        predicted.humidity = -1
        print("humidity is  "+  result4_1[0] +"%")

    if '10'<result4_1 < '30' or '40'<result4_1 < '60':
        predicted.humidity = 0
        print("humidity is  "+  result4_1[0] +"%")
        
def textrecogition():
    feelingtext_data = [
        ('I feel good.', 'pos'),
        ('It can not be better', 'pos'),
        ('the dinner is delicious', 'pos'),
        ('a nice day', 'pos'),
        ("yesterday is bad. but today everythings can not be better", 'pos'),
        ('today is bad', 'neg'),
        ('i feel rather horrible', 'neg'),
        ("i am so embarrassed", 'neg'),
        ('so bad a film!', 'neg'),
        ('/cy /cy.', 'pos'),
        ('passed away', 'pos'),
        ('I missed you so much', 'neg'),
        ('can not be worse', 'neg'),
        ('bad weather', 'neg'),
        ("I never want to do this again", 'neg'),
        ('I do not enjoy my job', 'neg'),
        ('i am so sad', 'neg'),
        ("i am too hot", 'neg'),
        ('I love this film', 'neg'),
        ('/cy /cy.', 'pos'),
        ('/ll /ll.', 'neg'),
        ('i hate exams', 'neg')
        ]
    cl = NaiveBayesClassifier(feelingtext_data)
    circleMessage = pd.read_csv('moment.txt', index_col=False, header=0)
    serie = circleMessage.transpose()
    
    if  cl.classify(serie)=='neg':
        predicted.words = -1
    else:
        predicted.words =  1
    
    if len(serie) == 0 :
        predicted.words =   0
    
    shape = (1,8,8 )
    blocks1 = np.lib.stride_tricks.as_strided(imread("1.jpg"), shape=shape)
    blocks2 = np.lib.stride_tricks.as_strided(imread("2.jpg"), shape=shape)
    blocks3 = np.lib.stride_tricks.as_strided(imread("3.jpg"), shape=shape)
    blocks4 = np.lib.stride_tricks.as_strided(imread("4.jpg"), shape=shape)
    blocks5 = np.lib.stride_tricks.as_strided(imread("5.jpg"), shape=shape)
    blocks6 = np.lib.stride_tricks.as_strided(imread("6.jpg"), shape=shape)
    blocks7 = np.lib.stride_tricks.as_strided(imread("7.jpg"), shape=shape)
    blocks8 = np.lib.stride_tricks.as_strided(imread("8.jpg"), shape=shape)
    blocks9 = np.lib.stride_tricks.as_strided(imread("9.jpg"), shape=shape)
    blocks10 = np.lib.stride_tricks.as_strided(imread("10.jpg"), shape=shape)
    blocks11 = np.lib.stride_tricks.as_strided(imread("11.jpg"), shape=shape)
    blocks12 = np.lib.stride_tricks.as_strided(imread("12.jpg"), shape=shape)
    blocks13 = np.lib.stride_tricks.as_strided(imread("13.jpg"), shape=shape)
    blocks14 = np.lib.stride_tricks.as_strided(imread("14.jpg"), shape=shape)
    blocks15 = np.lib.stride_tricks.as_strided(imread("15.jpg"), shape=shape)
    blocks16 = np.lib.stride_tricks.as_strided(imread("16.jpg"), shape=shape)
    blocks17 = np.lib.stride_tricks.as_strided(imread("17.jpg"), shape=shape)
    blocks18 = np.lib.stride_tricks.as_strided(imread("18.jpg"), shape=shape)
    blocks19 = np.lib.stride_tricks.as_strided(imread("19.jpg"), shape=shape)
    blocks20 = np.lib.stride_tricks.as_strided(imread("20.jpg"), shape=shape)
    blocks21 = np.lib.stride_tricks.as_strided(imread("21.jpg"), shape=shape)
    blocks22 = np.lib.stride_tricks.as_strided(imread("22.jpg"), shape=shape)
    blocks23 = np.lib.stride_tricks.as_strided(imread("23.jpg"), shape=shape)
    blocks24 = np.lib.stride_tricks.as_strided(imread("24.jpg"), shape=shape)
    blocks25 = np.lib.stride_tricks.as_strided(imread("25.jpg"), shape=shape)
    blocks26 = np.lib.stride_tricks.as_strided(imread("26.jpg"), shape=shape)    
    
    a1=np.vstack((blocks1,blocks2))
    a2=np.vstack((blocks3,blocks4))
    a3=np.vstack((blocks5,blocks6))
    a4=np.vstack((blocks7,blocks8))
    a5=np.vstack((blocks9,blocks10))
    a6=np.vstack((blocks11,blocks12))
    a7=np.vstack((blocks13,blocks14))
    a8=np.vstack((blocks15,blocks16))
    a9=np.vstack((blocks17,blocks18))
    a10=np.vstack((blocks19,blocks20))
    a11=np.vstack((blocks21,blocks22))
    a12=np.vstack((blocks23,blocks24))
    a13=np.vstack((blocks25,blocks26))
    a14=np.vstack((a1,a2))
    a15=np.vstack((a3,a4))
    a16=np.vstack((a5,a6))
    a17=np.vstack((a7,a8))
    a18=np.vstack((a9,a10))
    a19=np.vstack((a11,a12))


    a20=np.vstack((a13,a14))
    a21=np.vstack((a15,a16))
    a22=np.vstack((a17,a18))
    a23=np.vstack((a19,a20))
    a24=np.vstack((a21,a22))
    a25=np.vstack((a23,a24))
    shape = (26,64)
    blocks = np.lib.stride_tricks.as_strided(a25, shape=shape)
    target = [0,0,0,0,0,0,0,0,1,1,1,1,1,1,1,1,0,0,0,1,1,1,1,1,1,0]
    imagesdataset = {'images':a25,'data':blocks,'target':[0,0,0,0,0,0,0,0,1,1,1,1,1,1,1,1,0,0,0,1,1,1,1,1,1,0]}

    svc_1 = SVC(kernel='linear')
    clf = svc_1
    clf.fit(blocks, target)
    correctrate = clf.score(blocks, target)
    blocksdepress = np.lib.stride_tricks.as_strided(imread("depress.jpg"),shape=(1,64))
    imagerecog = clf.predict(blocksdepress)

    if imagerecog == [1]:
        print ("the image should be positive")
        print ("the images recognition accuracy is %f" %correctrate)
        predicted.colors = 1
    
    else:
        print ("the image should be negative")
        print ("the images recognition accuracy is %f" %correctrate)
        predicted.colors = 0

def feelingpred():
    feature_cols = ['weather', 'Temperature', 'Air', 'weekdays?', 'humidity', 'amountofpeople','words', 'colors', 'amounts', 'music']
    X = data_training[feature_cols]
    y = data_training['feeling']
    y = data_training.feeling
    y_topred=predicted[feature_cols]
    #fitting
    clf = svm.SVR()
    clf.fit(X, y)
    predict=clf.predict(y_topred)
    print ("the prediction of feeling number is %f" % predict)
    prediction['feeling'] = predict
    df1 = pd.DataFrame(prediction, columns = ['feeling'])
    df1.to_csv('predictdata.csv')
    #predict the feeling number under the given parameters & save the number in the predictdata.csv
    
def getlumination():
    ser = serial.Serial("/dev/ttyAMA0", 9600)
    ser.flushInput()
    time.sleep(1.5)
    count = ser.inWaiting()
    if count != 0:
        currentlumination = pd.read_csv('currentlumination.csv')   
        recv = ser.read(count) 
        currentlumination.lumination = recv
        df2 = pd.DataFrame(currentlumination, columns = ['lumination'])
        df2.to_csv('currentlumination.csv')
        print("current lumination is "+ recv +"lux")  
    ser.flushInput()  
    time.sleep(2)

def returnresult():
    ser = serial.Serial("/dev/ttyAMA0", 9600)
    predict = pd.read_csv('predictdata.csv')
    feeling = predict.feeling
    data=""
    if  feeling[0] >= 80:
        data = "5"
    if  70 < feeling[0] < 80:
        data = "4"
    if  60 < feeling[0] <= 70:
        data = "3"
    if  50 < feeling[0] <= 60:
        data = "2"
    if  feeling[0] <= 50:
        data = "1"

    ser.write(data)  


if __name__ == '__main__':  
    while True:
        webdata()
        textrecogition()
        feelingpred()
        getlumination()
        returnresult()
