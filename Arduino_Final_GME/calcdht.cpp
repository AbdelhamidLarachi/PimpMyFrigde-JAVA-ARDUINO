#include <DHT.h>
#include "calcdht.h"

//Constantes
#define PIN_NTC 0
#define DHTPIN 7     // détermination du port de connection
#define DHTTYPE DHT22   // détermination du type de sonde DHT 22  (AM2302)
#define HUMIDITY 0
#define TEMPERATURE 1
#define VVALUE 2

DHT dht(DHTPIN, DHTTYPE); // initialisation de la sonde DHT 22

float *CalculDHT(int V_IN, float valuedht[]){
  
  //Calcul de la tension sur la borne analogique
  double valeurAnalog = analogRead(PIN_NTC);
  valuedht[VVALUE] =  valeurAnalog / 1024 * V_IN;

  valuedht[HUMIDITY] = dht.readHumidity(); //lecture et enregistrement des variables hum et temp
  valuedht[TEMPERATURE] = dht.readTemperature();

  return valuedht;
}

void InitDHT(){
    dht.begin();
}
