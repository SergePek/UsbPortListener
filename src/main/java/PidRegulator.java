import javax.naming.Context;
import javax.usb.UsbException;
import javax.usb.UsbHostManager;
import javax.usb.UsbServices;
import java.io.InputStream;
import java.util.Scanner;

public class  PidRegulator{
    double ust = 20.0;
    double lastInput = ust;
    double P,I,D,output,lastP,input,error;
    double Kp=2;
    double Ki=1;
    double Kd=0.5;
    double pid(double input){
        lastP= P;
        P = lastInput - input;
        lastInput = input;
        System.out.println("Пропорциональный: " + P);
        error = ust - input;
        if(error<=0) I=0;
        else I+=error;
        if(I>100) I=100;
        System.out.println("Интегральный: " + I);
        D = P - lastP;
        System.out.println("Дифференциальный: " + D);
        output = Kp*P+Ki*I+Kd*D;
        if (output<0) output = 0;
        if(output>100) output = 100;
        System.out.println("Мощность: " + output);
        return input;
    }
    public static void main(String[] args) throws UsbException {
        PidRegulator one = new PidRegulator();
        while (true){
        Scanner scanner = new Scanner(System.in);
        double temp = scanner.nextDouble();
        one.pid(temp);

        }
    }

}
