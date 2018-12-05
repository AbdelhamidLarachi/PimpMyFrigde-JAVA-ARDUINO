//Abdelhamid Larachi

#include <math.h>
#include <Adafruit_Sensor.h>
#include <DHT.h>
#include "thermistance.h"
#include "send.h"
#include "calcdht.h"

#define PELTIER 3
//Variables
int chk;
double celsius;
float consigne;
double V_IN = 5.0; //Alimentation électrique
int ledPin = 10;

int power = 0;
int peltier_level = map(power, 0, 99, 0, 255);

float valuedht[] = {0,0,0};

void setup() {
  Serial.begin(9600);
  InitDHT();
      pinMode(ledPin, OUTPUT);  //TEst frigo

}

void loop() { 

  CalculDHT(V_IN, valuedht);
  
  celsius = CalculTemp(V_IN, &valuedht[0]);
  SendData(celsius, valuedht[1], valuedht[0]);
  consigne = CastData();
  
  if(consigne <= valuedht[1]) {
  power = 0;
              digitalWrite(ledPin, HIGH);         // turned off ! 

  }
  
  else {
  power = 99;
                digitalWrite(ledPin, LOW);         // turned off ! 

  }
  
  peltier_level = map(power, 0, 99, 0, 255);
  
  analogWrite(PELTIER, peltier_level); //Ecrit cette nouvelle valeur dans le port
  //delay(1000);
}
