//Small thrift service to establish comm with the device
//used as interface wrapper
namespace java gpscomm

service GPSComm{
	string getCommString(),
}
