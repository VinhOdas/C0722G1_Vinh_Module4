package vinhodas.service.impl;

import org.springframework.stereotype.Service;
import vinhodas.service.ICalculotorSerivce;
@Service
public class CalculatorService implements ICalculotorSerivce {
    @Override
    public double addition(double a, double b,String calculation) {
        double result;
        switch (calculation) {
            case "Addition(+)":
                result = a + b;
                break;
            case "Subtraction(-)":
                result = a - b;
                break;
            case "Multiplication(*)":
                result = a * b;
                break;
            case "Division(/)":
                result = a / b;
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + calculation);
        }
        return result;
    }


}
