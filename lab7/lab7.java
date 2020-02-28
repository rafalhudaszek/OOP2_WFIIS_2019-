import java.io.*;

public class lab7 {
    public static void main(String[] args)
    {        
        boolean didError = false;
        double avg = 0;
        try {
            if (args.length != 2 )
            {
                throw new Exception();
            }
        }
        catch (Exception e)
        {
            System.out.println("Insert in your command line two files. One with data, secound empty");
            return;
        }



        try
        {
            BufferedReader f = new BufferedReader(new FileReader(args[0]) );
            String line;
            int countLines = 0;
            while( (line = f.readLine()) != null )
            {
                countLines++;
                avg += Double.parseDouble(line);
            }

            avg /= countLines;

            if (avg == Double.POSITIVE_INFINITY) throw new ArithmeticException();

        }
        catch( FileNotFoundException e)
        {
            System.out.println( "Warrning, we couldnt find your files" + args[0] + "." );
            didError = true;
        }
        catch ( IOException e )
        {
            System.out.println( "Warrning, there is a problem with opening file" );
            didError = true;
        }

        catch( ArithmeticException e )
        {
            System.out.println( "Warrning, your data are to big or division by 0  " );
            didError = true;
        }
        catch( Exception e )
        {
            System.out.println( "Warring, somthing went no yes xD" );
            didError = true;
        }

        if (didError) return;

        FileWriter writer = null;
        try
        {
            writer = new FileWriter(new File(args[1]));
            writer.write(String.valueOf(avg));
        }
        catch (IOException e)
        {
            System.out.println( "Warrning, there was a problem with writing data to file" + args[1] + "." );            
        }
        finally
        {
            try
            {
                writer.close();
            }
            catch (IOException e)
            {
                System.out.println( "Warning, there was a problem with closing file " + args[1] + "." );
            }
        }
    }
}
