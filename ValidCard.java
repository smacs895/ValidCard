import javax.swing.JOptionPane; // For user input and to show Dialog boxes. 

//A program to check if a credit card number (between 9 and 16 digits) is valid or invalid.
public class ValidCard{
    // Set isValid as false initially, as we need to prove that a card number is valid. 
    private static boolean isValid=false;

    public static void main(String[] args){
        // Ask for the card number via a JOptionPane dialog box. 
        String cdNumber = JOptionPane.showInputDialog(null, "Enter your card Number please.");
        // Initialize size to the length of the card number provided. 
        int size = cdNumber.length();
        // Initialize an int array, with the size of the card number provided. 
        int [] cardNumber = new int [size];
        
        // Search through the array to get each digit. 
        for(int i=0; i<size; i++){
            cardNumber[i] = Character.getNumericValue(cdNumber.charAt(i));
        }
        // Use the isValidCredirCardNumber method to determine if valid or invalid. 
        isValid = isValidCreditCardNumber(cardNumber);
        
        // Output if the card number is valid or invalid. 
        if(isValid){
           JOptionPane.showMessageDialog(null, "This is a Valid Card number.");
        }else{
           JOptionPane.showMessageDialog(null, "INVALID Card number");
        }
    }

    // Method to determine if the card number is valid or invalid. 
    public static boolean isValidCreditCardNumber(int [] creditCardNumber){
        int index, temp, sumOfOddPositionedDigits = 0, sumOfEvenPositionedDigits = 0;   
        
        // Search through the array creditCardNumber, that is passed in as a parameter, to get 
        // the sum of the odd positioned digits. 
        for(index = 0; index < creditCardNumber.length; index += 2){
            temp = creditCardNumber[index] * 2;
              if(temp < 10){
                sumOfOddPositionedDigits += temp;
              }else{
                sumOfOddPositionedDigits += (temp % 10) + 1;
              }
        }       
        
        // Search through the array to get the sum of the even position digits. 
        for(index = 1; index < creditCardNumber.length; index += 2){
            sumOfEvenPositionedDigits += creditCardNumber[index];
        }
        
        // Check to see if the formula results in 0 or 1.
        // If 0, the card number is valid. 
        // Else, the card number is invalid. 
        temp = (sumOfOddPositionedDigits + sumOfEvenPositionedDigits) % 10;
        
        // If the formula results in 0, then the card number is false, else it is invalid. 
        if(temp == 0){
            return true;
        }else{
            return false;
        }
    }
}