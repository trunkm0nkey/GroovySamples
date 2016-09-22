class IOExample {


    static def PrintByLine(String filename) {
        //def filename = "InputFile"
        new File(filename).eachLine {
            println it
            //Also works:
            //line -> println "$line"
        }
    }

    static def ReadAsString(String filename) {
        def file = new File(filename)
        println file.text
    }

    static def WriteToFile(String filename, String str) {
        new File(filename).withWriter('utf-8') {
            it.writeLine str
            //Also works
            //writer -> writer.writeLine str
        }
    }

    static def PrintFileSize(String filename) {
        def file = new File(filename)
        println "$file has ${file.size()} bytes"
    }

    /*-- Other quick functions ------
        file.isFile()
        file.isDirectory()
        file.mkdir() //def file = new File('E:\newDir')
        file.delete()
        dst << src.text //Copy file where dst and src are file hamdles

    */


    //-- Begin main method --
    static void main(String[] args) {
        def inFile = "InputFile"
        def outFile = "OutputFile"
        def someText = "Bob LaBlaw's Law Blog"

        println "Running PrintByLine()"
        PrintByLine(inFile)
        println "Running ReadAsString()"
        ReadAsString(inFile)
        println "Runnning WriteToFile('$outFile','$someText')"
        WriteToFile(outFile,someText)
        println "OutputFile now contains:"
        ReadAsString(outFile)
        println "Running PrintFileSize() for $inFile and then $outFile."
        PrintFileSize(inFile)
        PrintFileSize(outFile)
    }

}