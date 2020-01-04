package VoterMan.com;

import android.app.AlertDialog;
import android.content.Context;
import android.os.AsyncTask;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

public class background extends AsyncTask <String, Void, String> {


    AlertDialog dialog;
    Context context;

    public background(Context context){
        this.context = context;
    }

    @Override
    protected void onPreExecute() {
        dialog = new AlertDialog().Builder(context).create();
        dialog.setTitle("Login status");
        dialog.setTitle("register status");
    }

    @Override
    protected void onPostExecute(String s) {
        dialog.setMessage(s);
        dialog.show();
    }

    @Override
    protected String doInBackground(String... Voids) {
        String result = "";
        String Email_Address = Voids[0];
        String Password = Voids[1];
        String name = Voids[2];
        String Gender = Voids[3];
        String dob = Voids[4];
        String C_Password = Voids[5];

        String connstr = "http:// localhost:8080/login.php";
        String connstr = "http:// localhost:8080/register.php";

        try {
            URL url = new URL(connstr);
            HttpURLConnection http = (HttpURLConnection) url.openConnection();
            http.setRequestMethod("POST");
            http.setDoInput(Boolean.parseBoolean("true"));
            http.setDoOutput(Boolean.parseBoolean("True"));


            OutputStream ops = http.getOutputStream();
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(ops, "UTF-8"));
            String data = URLEncoder.encode("Email_Address", "UTF-8") + "=" + URLEncoder.encode(Email_Address, "UTF-8")
                    +"&&"+ URLEncoder.encode("Password", "UTF-8") + "=" + URLEncoder.encode(Email_Address, "UTF-8")
                    +"&&"+ URLEncoder.encode("Gender", "UTF-8") + "=" + URLEncoder.encode(Email_Address, "UTF-8")
                    +"&&"+ URLEncoder.encode("dob", "UTF-8") + "=" + URLEncoder.encode(Email_Address, "UTF-8")
                    +"&&"+ URLEncoder.encode("C_Password", "UTF-8") + "=" + URLEncoder.encode(Email_Address, "UTF-8")
                    +"&&"+ URLEncoder.encode("name", "UTF-8") + "=" + URLEncoder.encode(Email_Address, "UTF-8");

            writer.write(data);
            writer.flush();
            writer.close();
            ops.close();

            InputStream ips = http.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(ips, "ISO-8859-1"));
            String Line = "";
            while ((Line = reader.readLine()) != null)
            {
                result += Line;
            }

            reader.close();
            ips.close();
            http.disconnect();
            return result;


        } catch (MalformedURLException e) {
            result = e.getMessage();
        }
        catch (IOException e){
            result = e.getMessage();

        }

        return null;
    }

    @Override
    protected void onProgressUpdate(Void... values) {
        super.onProgressUpdate(values);
    }

}
