#include "thermistance.h"
#include <math.h>
#include <Adafruit_Sensor.h>
#include <DHT.h>

#define RREF 10000 //Résistance de référence à 25°C


//Information de la thermistance
double A_1 = 3.354016E-3;
double B_1 = 2.569850E-4;
double C_1 = 2.620131E-6;
double D_1 = 6.383091E-8;

float valuedhttherm[0];

double SteinhartHart(double R)
{
  //Division de l'équation en 4 parties. La premiere est
  //uniquement A1
  double equationB1 = B_1 * log(R / RREF);
  double equationC1 = C_1 * pow(log(R / RREF), 2);
  double equationD1 = D_1 * pow(log(R / RREF), 3);
  double equation = A_1 + equationB1 + equationC1 + equationD1;
  return pow(equation, -1);

}

double CalculTemp(int V_IN, float valuedhttherm[]){
    //Calcul de la résistance de la thermistance
  double Rth = (RREF * valuedhttherm[2] ) / (V_IN - valuedhttherm[2]);
  //Calcul de la température en kelvin( Steinhart and Hart)
  double kelvin = SteinhartHart(Rth);
  double celsius = kelvin - 273.15; //Conversion en celsius

  return celsius;
}
