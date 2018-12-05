#include <math.h>
#include <Adafruit_Sensor.h>
#include <DHT.h>
#include "send.h"

String displayplay = "";
String data = "";
char inputBuffer[10];
int bufferSize;
int x = 0;
String vide = "";
float order;

void SendData (double celsius, float temp, float hum){

  displayplay = vide;
  
  displayplay += celsius;
  displayplay += "/";
  displayplay += temp;
  displayplay += "/";
  displayplay += hum;
  displayplay += "/";

  if (Serial.available() > 0) {
    data = vide;
    Serial.readBytes(inputBuffer, Serial.available());
    bufferSize = strlen(inputBuffer);
    
    for (int i = 0; i <= bufferSize ; i++) {
      data += inputBuffer[i];
      inputBuffer[i] = 0;
    }
    
    x++;
  } 
  
  if (x == 0) {
    displayplay += "null";
  }
  
  else {
    displayplay += data;
  }

  Serial.println(displayplay);
}

float CastData(){
  order = data.toFloat();
  return order;
}

