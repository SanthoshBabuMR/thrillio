package com.semanticsquare.thrillio.util;

import java.io.*;

public class IOUtil {
  public static void read(String[] data, String filename) {
    try(BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(filename), "UTF-8"))) {
      String line;
      int count = 0;
      while ((line = br.readLine()) != null) {
        data[count] = line;
        count++;
      }
    } catch (UnsupportedEncodingException e) {
      System.out.println("UnsupportedEncodingException");
      e.printStackTrace();
    } catch (FileNotFoundException e) {
      System.out.println("FileNotFoundException");
      e.printStackTrace();
    } catch (IOException e) {
      System.out.println("IOException");
      e.printStackTrace();
    }
  }

  public static String read(InputStream in) {
    StringBuilder content = new StringBuilder();
    try(BufferedReader br = new BufferedReader(new InputStreamReader(in, "UTF-8"))) {
      String line;
      while ((line = br.readLine()) != null) {
        content.append(line).append("\n");
      }
    } catch (UnsupportedEncodingException e) {
      System.out.println("UnsupportedEncodingException");
      e.printStackTrace();
    } catch (FileNotFoundException e) {
      System.out.println("FileNotFoundException");
      e.printStackTrace();
    } catch (IOException e) {
      System.out.println("IOException");
      e.printStackTrace();
    }
    return content.toString();
  }

  public static void write(String webpage, long id) {
    String pagesPrefix = "/Users/babusa/Documents/webster/project/thrillio/src/com/semanticsquare/thrillio/pages/";
    try(BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(pagesPrefix + String.valueOf(id) + ".html"), "UTF-8"))) {
      writer.write(webpage);
    } catch (UnsupportedEncodingException e) {
      System.out.println("UnsupportedEncodingException");
      e.printStackTrace();
    } catch (FileNotFoundException e) {
      System.out.println("FileNotFoundException");
      e.printStackTrace();
    } catch (IOException e) {
      System.out.println("IOException");
      e.printStackTrace();
    }
  }
}
