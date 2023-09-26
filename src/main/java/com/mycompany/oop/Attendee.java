package com.mycompany.oop;

public class Attendee extends User {
    
        private static int numOfAttendee = -1;
        private String attendeeID;
        private String seminarID;
        private Payment payment;
        
    public Attendee(String id, String password, String name, String contactInfo, String seminarID, Payment payment) {
        super(id, password, name, "Attendee", contactInfo);
            
            this.attendeeID = id;
            this.seminarID = seminarID;
            this.payment = payment;       
            numOfAttendee++;

        }
        public static int getNumOfAttendee(){
            return numOfAttendee;
        }   

        public String getMethod(){

            return payment.getMethod();
        }

        public double getTotal(){

            return payment.getTotal();
        }

        public String toString(){

            return attendeeID;
        }

        public String getSeminarID(){

            return seminarID;
        }

        public String getID(){

            return attendeeID;
        }
        
        public String getUserID(){
            
            return super.getid();
        }
        
        public String getUserName(){
            
            return super.getname();
        }
        
        public String getPswd(){
            
            return super.getpassword();
        }
        
        
}
    
