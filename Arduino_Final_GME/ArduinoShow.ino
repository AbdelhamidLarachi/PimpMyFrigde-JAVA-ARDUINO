//ABDELHAMID LARACHI 

//Libraries
#include <DHT.h>;

//Constants
#define DHTPIN 7     // what pin we're connected to
#define DHTTYPE DHT22   // DHT 22  (AM2302)
DHT dht(DHTPIN, DHTTYPE); //// Initialize DHT sensor for normal 16mhz Arduino

//CONSTANTES

int ThermistorPin = 0;
int Vo;
float R1 = 10000;
float logR2, R2, to;
float c1 = 1.009249522e-03, c2 = 2.378405444e-04, c3 = 2.019202697e-07;
int ledPin = 10;

//Variables

float h;  //Stores humidity value
float ti; //Stores temperature value

void setup()
{
  Serial.begin(9600);
  dht.begin();

    pinMode(ledPin, OUTPUT);  //TEst frigo
    

}

void loop()
{
  
delay(2000);
    //Read data and store it to variables hum and temp
    h = dht.readHumidity();
    ti = dht.readTemperature();
    //Print temp, humidity and dew point values to serial monitor
    Serial.print(" Humidity: ");
    Serial.print(h);
    Serial.print(" %, Temp Inside: ");
    Serial.print(ti);
    Serial.print(" °C ");
    float coeffDP = log(h / 100) + ((17.62 * ti) / (243.5 + ti));
    float dp = 243.5 * coeffDP / (17.62 - coeffDP);
    Serial.print(" Dew Point: ");
    Serial.print(dp);

    Vo = analogRead(ThermistorPin); //V0
    R2 = R1 * (1023.0 / (float)Vo - 1.0);
    logR2 = log(R2);
    to = (1.0 / (c1 + c2*logR2 + c3*logR2*logR2*logR2));
    to = to - 273.15;
    //to = (to * 9.0)/ 5.0 + 32.0; //convert to F

    Serial.print(" Temperature outside: "); 
    Serial.print(to);
    Serial.print(" °C \n");     

    float diff = ti-dp;
//RÉGULATEUR 

if(diff<=3.00){
      Serial.print("ALERTE! LESS THAN "); 
      Serial.print(diff);
      Serial.print("°C TO START CONDESATION");
    }  
    if(ti<=dp){
            Serial.print("THE FRIDGE IS OFF! IT WILL RESTART AUTOMATICALLY");
            digitalWrite(ledPin, LOW);         // turn off
    }  
else { digitalWrite(ledPin, HIGH);           // reactivate.
}
}


   