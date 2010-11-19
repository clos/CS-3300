import sys
import COMM
sys.path.append('./gen-py')
sys.path.append('./thrift')

#rename if needed
from gpscomm import GPSComm
from gpscomm.ttypes import *

from thrift.transport import TSocket
from thrift.transport import TTransport
from thrift.protocol import TBinaryProtocol
from thrift.server import TServer


class GPSHandler:
  def __init__(self):
    self.log = {}

  def string getCommString(self):
    return COMM.readGPS()

handler = GPSHandler()
processor = GPSComm.Processor(handler)
transport = TSocket.TServerSocket(9090)
tfactory = TTransport.TBufferedTransportFactory()
pfactory = TBinaryProtocol.TBinaryProtocolFactory()

server = TServer.TSimpleServer(processor, transport, tfactory, pfactory)

print 'Start the server!'
server.serve()
print 'Up and ready sir!'
