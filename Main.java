package com.company;

interface HaiVolt      {
    void Telepho();
    void HighCharge(); }

interface LowVolt     {
    void Telepho();
    void LowCharge(); }

class HighVoltage implements HaiVolt {
    public void Telepho(){
        System.out.println("Телефон подключен к зарядке:");
                         }

    public void HighCharge(){
        System.out.println("\t" + "(Мощность розетки 380 Вольт)" + "\n");
                            }        }

class LowVoltage implements LowVolt {
    public void Telepho(){
        System.out.println("Телефон подключен к зарядке:");
                          }

    public void LowCharge(){
        System.out.println("\t" + "(Мощность розетки 220 Вольт)");
                           }        }

class SocketPower {
    private HaiVolt highConnection;
    public SocketPower(HaiVolt highConnection){
        this.highConnection = highConnection; }

    public void Connect(){
        highConnection.Telepho();
        highConnection.HighCharge();
                         }
                  }

class SocketPowerAdapter implements HaiVolt {
    LowVolt lowVoltageConnection;
    public SocketPowerAdapter(LowVolt lowConnection){
        this.lowVoltageConnection = lowConnection;  }

    public void Telepho(){
        lowVoltageConnection.Telepho();
                         }
    public void HighCharge(){
        lowVoltageConnection.LowCharge();
                            }               }

public class Main {
    public static void main(String[] args) {
        HighVoltage highVoltage = new HighVoltage();
        SocketPower highPower = new SocketPower(highVoltage);
        highPower.Connect();
        SocketPowerAdapter socketPowerAdapter = new SocketPowerAdapter(new LowVoltage());
        SocketPower socketLowPower = new SocketPower(socketPowerAdapter);
        socketLowPower.Connect();          }
                  }