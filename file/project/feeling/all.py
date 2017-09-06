'''
Created on Mar 22, 2017

@author: chengkai
'''

import Image
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


data_training = pd.read_csv('feelingparameters.csv')
predicted = pd.read_csv('currentdata.csv')
prediction = pd.read_csv('predictdata.csv')

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

if serie is None:
    predicted.words =   0
else:
    pass


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
#predict the feeling number under the given parameters & save the number in the predictdata.csv


    
