class ErrorExample {
  static void main (String[] args) {
      try {
      def arr = new int[3]
      arr[5] = 5 //Trying to add to non-existing array index
    } catch (ArrayIndexOutOfBoundsException e) {
      println "Caught an Array out of Bounds exception"
    } catch(Exception e) {
      println "-- Caught exception: --"
      println e
      println "-----------------------"
      /*
        You can also use these methods with an exception.

        e.getMessage()
        e.getCause()
        e.toString()
        e.printStackTract()
        and more...
       */
    } finally {
      println "This finally statement always prints."
    }
    println "This comes after all try, catch, and finally blocks."
  }
}