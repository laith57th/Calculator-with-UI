package OperationPackage;

public class Operand {
 private int opValue;

 public Operand(String token) {
  this.opValue = Integer.parseInt(token);
 }

 public Operand(int value) {
  this.opValue = value;
 }

 public int getValue() {
  return opValue;
 }

 public static boolean isNumber(String token) {
 try {
  Integer.parseInt(token);
 }catch (NumberFormatException e) {
    return false;
   }
  return true;
 }
}
