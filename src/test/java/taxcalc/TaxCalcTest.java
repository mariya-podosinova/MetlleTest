package taxcalc;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Ignore;
import org.junit.Test;

public class TaxCalcTest {

  @Test
  public void canCalculateTax() {
    Integer totalAmount = new TaxCalc(10)
    .netAmount(
        new TaxCalc.Pair<>(40, "GBP"),
        new TaxCalc.Pair<>(50, "GBP"),
        new TaxCalc.Pair<>(60, "GBP")
      )
      .amount;
    assertEquals(135, totalAmount.intValue());
  }

  @Test
  public void canCalculateTax_withZeroAmount() {
    Integer totalAmount = new TaxCalc(10)
    .netAmount(new TaxCalc.Pair<>(0, "GBP"))
      .amount;
    assertEquals(0, totalAmount.intValue());
  }

  @Ignore
  @Test
  public void cannotCalculateTax_withNegativeAmount() {
    try {
      new TaxCalc(10).netAmount(new TaxCalc.Pair<>(-50, "GBP"));
      fail("Should have failed");
    } catch (Exception e) {
      System.out.println("Something went wrong.");
    }
  }

  @Test
  public void cannotCalculateTax_withNullAmount() {
    try {
      new TaxCalc(10).netAmount(new TaxCalc.Pair<>(null, "GBP"));
      fail("Should have failed");
    } catch (Exception e) {
      System.out.println("Something went wrong.");
    }
  }

  @Test
  public void canCalculateTax_withEmptyStringCurrency() {
    Integer totalAmount = new TaxCalc(10)
    .netAmount(new TaxCalc.Pair<>(40, ""))
      .amount;
    assertEquals(36, totalAmount.intValue());
  }

  @Test
  public void cannotCalculateTax_withDifferentFormatCurrency() {
    try {
      new TaxCalc(10)
      .netAmount(
          new TaxCalc.Pair<>(50, "oop"),
          new TaxCalc.Pair<>(50, "0op"));
      fail("Should have failed");
    } catch (Exception e) {
      System.out.println("Something went wrong.");
    }
  }

  @Ignore
  @Test
  public void cannotCalculateTax_withSymbolInCurrency() {
    try {
      new TaxCalc(10).netAmount(new TaxCalc.Pair<>(40, "'"));
      fail("Should have failed");
    } catch (Exception e) {}
  }

  @Test
  public void cannotSumDifferentCurrencies() {
    try {
      new TaxCalc(10)
      .netAmount(new TaxCalc.Pair<>(4, "GBP"), new TaxCalc.Pair<>(5, "USD"));
      fail("Should have failed");
    } catch (Exception e) {
      System.out.println("Something went wrong.");
    }
  }

  @Test
  public void irrelevantExceptionThatCouldBeThrown() {
    try {
      new TaxCalc(10)
      .netAmount(new TaxCalc.Pair<>(4, "GBP"), new TaxCalc.Pair<>(5, "USD"));
    } catch (Exception e) {
      System.out.println("Something went wrong.");
    }
  }

  @Test
  public void canCalculateTax_withZeroTax() {
    Integer totalAmount = new TaxCalc(0)
    .netAmount(new TaxCalc.Pair<>(20, "GBP"))
      .amount;
    assertEquals(20, totalAmount.intValue());
  }

  @Ignore
  @Test
  public void cannotCalculateTax_withNegativeTax() {
    try {
      new TaxCalc(-10).netAmount(new TaxCalc.Pair<>(20, "GBP"));
      fail("Should have failed");
    } catch (Exception e) {
      System.out.println("Something went wrong.");
    }
  }

  @Ignore
  @Test
  public void cannotCalculateTax_withTaxGreaterThan100() {
    try {
      new TaxCalc(100).netAmount(new TaxCalc.Pair<>(20, "GBP"));
      fail("Should have failed");
    } catch (Exception e) {
      System.out.println("Something went wrong.");
    }
  }
}
