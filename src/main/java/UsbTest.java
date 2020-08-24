
import jssc.SerialPort;
import jssc.SerialPortEvent;
import jssc.SerialPortEventListener;
import jssc.SerialPortException;

import javax.usb.*;

public class UsbTest {
    private static SerialPort serialPort;
    public static void main(String[] args) throws UsbException, SerialPortException {
        serialPort = new SerialPort ("COM8"); /*Передаем в конструктор суперкласса имя порта с которым будем работать*/
        try {
            serialPort.openPort (); /*Метод открытия порта*/
            serialPort.setParams (SerialPort.BAUDRATE_9600, SerialPort.DATABITS_8, SerialPort.STOPBITS_1, SerialPort.PARITY_NONE); /*Задаем основные параметры протокола UART*/
            serialPort.setEventsMask (SerialPort.MASK_RXCHAR); /*Устанавливаем маску или список события на которые будет происходить реакция. В данном случае это приход данных в буффер порта*/
            serialPort.addEventListener (new EventListener ()); /*Передаем экземпляр класса EventListener порту, где будет обрабатываться события. Ниже описан класс*/
        }
        catch (SerialPortException ex) {
            System.out.println (ex);
        }
    }

    private static class EventListener implements SerialPortEventListener { /*Слушатель срабатывающий по появлению данных на COM-порт*/
        public void serialEvent (SerialPortEvent event) {
            if (event.isRXCHAR () && event.getEventValue () > 0){ /*Если происходит событие установленной маски и количество байтов в буфере более 0*/
                try {
                    String data = serialPort.readString (event.getEventValue ()); /*Создаем строковую переменную  data, куда и сохраняем данные*/
                    Double temp = Double.valueOf(data);
                   // System.out.println(temp-10);
                    System.out.println ("Температура: "+temp);/*Выводим данные на консоль*/
                }
                catch (SerialPortException ex) {
                    System.out.println (ex);
                }
            }
        }
    }
}

