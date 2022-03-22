package taxcalc;

import java.util.Arrays;
import java.util.List;

class TaxCalc {
  int taxPercent;

  TaxCalc(int taxPercent) {
    this.taxPercent = taxPercent;
  }

  Pair<Integer, String> netAmount(
    Pair<Integer, String> firstPair,
    Pair<Integer, String>... rest
  ) {
    List<Pair<Integer, String>> pairs = Arrays.asList(rest);

    Pair<Integer, String> totalPair = firstPair;

    for (Pair<Integer, String> nextPair : pairs) {
      if (nextPair.currency != totalPair.currency) {
        throw new ApplicationException();
      }
      if (nextPair.amount == null || nextPair.currency == null) {
        throw new NullPointerException("File list cannot be null");
      }
    }

    for (Pair<Integer, String> nextPair : pairs) {
      totalPair =
        new Pair<>(totalPair.amount + nextPair.amount, nextPair.currency);
    }

    Double taxAmount = totalPair.amount * (taxPercent / 100.0);

    return new Pair<>(
      totalPair.amount - taxAmount.intValue(),
      firstPair.currency
    );
  }

  static class Pair<A, B> {
    final A amount;
    final B currency;

    Pair(A amount, B currency) {
      this.amount = amount;
      this.currency = currency;
    }
  }
}
