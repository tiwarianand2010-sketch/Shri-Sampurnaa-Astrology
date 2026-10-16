import 'package:flutter/material.dart';
import 'package:flutter_test/flutter_test.dart';
import 'package:shri_sampurnaa_astro/main.dart';

void main() {
  testWidgets('Shri Sampurnaa App smoke test', (WidgetTester tester) async {
    // ऐप को बिल्ड करें और फ्रेम रेंडर करें
    await tester.pumpWidget(const ShriSampurnaaApp());

    // जाँच करें कि ऐप का शीर्षक सही लोड हुआ है या नहीं
    expect(find.text('श्री संपूर्णम् ज्योतिष'), findsOneWidget);
  });
}
