package com.cleancode.knuth;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Objects;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class PrimePrinterTest {
  private PrintStream out;

  @Before
  public void setup() throws Exception {
    out = System.out;
    System.setOut(new PrintStream(Files.newOutputStream(Paths.get("lead.txt"))));
  }

  @After
  public void teardown() {
    System.out.close();
    System.setOut(out);
    new File("lead.txt").delete();
  }

  @Test
  public void make_sure_output_matches_gold() throws Exception {
    PrimePrinter.main(new String[0]);
    BufferedReader lead = null;
    BufferedReader gold = null;
    try {
      lead = new BufferedReader(new FileReader("lead.txt"));
      gold = new BufferedReader(new FileReader("gold.txt"));
      String line;
      while ((line = gold.readLine()) != null) assertEquals(line, lead.readLine());
      assertNull(lead.readLine());
    } finally {
      Objects.requireNonNull(lead).close();
      Objects.requireNonNull(gold).close();
    }
  }
}
