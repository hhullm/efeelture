import serial 

def bluetooth():
    ser = serial.Serial("/dev/ttyAMA0", 9600)
    da="AT\r\n"
    ser.write(da)

if __name__ == '__main__':
    bluetooth()
