import serial
import time #for potential later timestamped files
import pickle


##Get GPS data over serial##
ser = serial.Serial('COM3')  # open COM3, assuming that is port that will be used
#print ser.portstr       # debug line
s = ser.read(100)        # read up to 100 bytes NMEA documentation says that most devices
                        #will stream data, and ignore serial commands sent to them


##Dump data out##
ASCIIrep = pickle.dumps(s) #pack up string
print(ASCIIrep)         # send string to console
ser.close()             # close serial port
