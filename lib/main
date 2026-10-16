.dart
import 'package:flutter/material.dart';
import 'package:flutter_localizations/flutter_localizations.dart';

void main() async {
  WidgetsFlutterBinding.ensureInitialized();
  // यहाँ Firebase.initializeApp() और अन्य लोकल स्टोरेज इनिशियलाइज़ होंगे
  runApp(const ShriSampurnaaApp());
}

class ShriSampurnaaApp extends StatelessWidget {
  const ShriSampurnaaApp({super.key});

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      title: 'Shri Sampurnaa Astrology',
      debugShowCheckedModeBanner: false,
      themeMode: ThemeMode.dark,
      darkTheme: ThemeData(
        brightness: Brightness.dark,
        scaffoldBackgroundColor: const Color(0xFF0A0718),
        primaryColor: Colors.deepOrange,
        colorScheme: const ColorScheme.dark(
          primary: Colors.deepOrange,
          secondary: Colors.amber,
        ),
        cardColor: const Color(0xFF16122C),
        appBarTheme: const AppBarTheme(
          backgroundColor: Color(0xFF110E21),
          elevation: 2,
        ),
      ),
      // बहुभाषी समर्थन सेटअप
      supportedLocales: const [
        Locale('hi', 'IN'), // हिंदी
        Locale('en', 'US'), // अंग्रेजी
        Locale('ta', 'IN'), // तमिल
        Locale('te', 'IN'), // तेलुगु
        Locale('mr', 'IN'), // मराठी
      ],
      localizationsDelegates: const [
        GlobalMaterialLocalizations.delegate,
        GlobalWidgetsLocalizations.delegate,
        GlobalCupertinoLocalizations.delegate,
      ],
      home: const MasterDashboard(),
    );
  }
}

class MasterDashboard extends StatefulWidget {
  const MasterDashboard({super.key});

  @override
  State<MasterDashboard> createState() => _MasterDashboardState();
}

class _MasterDashboardState extends State<MasterDashboard> {
  int _currentIndex = 0;

  final List<Widget> _appScreens = [
    const JanamKundliEngineScreen(),
    const PrashnaKundliEngineScreen(),
    const GunMilanScreen(),
    const PanchangMuhuratScreen(),
    const DoshaRemediesScreen(),
    const AIAdvisorScreen(),
  ];

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: const Text(
          'श्री संपूर्णम् ज्योतिष',
          style: TextStyle(fontWeight: FontWeight.bold, color: Colors.amber),
        ),
        actions: [
          IconButton(
            icon: const Icon(Icons.notifications_active, color: Colors.amber),
            onPressed: () {},
          ),
        ],
      ),
      body: _appScreens[_currentIndex],
      bottomNavigationBar: BottomNavigationBar(
        currentIndex: _currentIndex,
        onTap: (index) => setState(() => _currentIndex = index),
        backgroundColor: const Color(0xFF110E21),
        selectedItemColor: Colors.amber,
        unselectedItemColor: Colors.white60,
        type: BottomNavigationBarType.fixed,
        items: const [
          BottomNavigationBarItem(icon: Icon(Icons.auto_awesome), label: 'कुंडली'),
          BottomNavigationBarItem(icon: Icon(Icons.psychology), label: 'प्रश्न'),
          BottomNavigationBarItem(icon: Icon(Icons.favorite), label: 'मिलान'),
          BottomNavigationBarItem(icon: Icon(Icons.calendar_month), label: 'पंचांग'),
          BottomNavigationBarItem(icon: Icon(Icons.shield), label: 'दोष/उपाय'),
          BottomNavigationBarItem(icon: Icon(Icons.chat_bubble), label: 'AI परामर्श'),
        ],
      ),
    );
  }
}

// 1. जन्म कुंडली इंजन (20 ग्रंथों से कनेक्टेड मॉडल UI)
class JanamKundliEngineScreen extends StatefulWidget {
  const JanamKundliEngineScreen({super.key});

  @override
  State<JanamKundliEngineScreen> createState() => _JanamKundliEngineScreenState();
}

class _JanamKundliEngineScreenState extends State<JanamKundliEngineScreen> {
  final _nameCtrl = TextEditingController();
  final _dobCtrl = TextEditingController();
  final _timeCtrl = TextEditingController();
  final _placeCtrl = TextEditingController();
  bool _isProcessing = false;
  bool _dataLoaded = false;

  void _triggerScriptureAnalysis() {
    setState(() => _isProcessing = true);
    Future.delayed(const Duration(seconds: 2), () {
      setState(() {
        _isProcessing = false;
        _dataLoaded = true;
      });
    });
  }

  @override
  Widget build(BuildContext context) {
    return SingleChildScrollView(
      padding: const EdgeInsets.all(16),
      child: Column(
        crossAxisAlignment: CrossAxisAlignment.start,
        children: [
          const Text('जन्म विवरण दर्ज करें (ग्रंथ-आधारित विश्लेषण)', style: TextStyle(fontSize: 16, fontWeight: FontWeight.bold, color: Colors.amber)),
          const SizedBox(height: 12),
          TextField(controller: _nameCtrl, decoration: const InputDecoration(labelText: 'जातक का नाम', border: OutlineInputBorder())),
          const SizedBox(height: 10),
          Row(
            children: [
              Expanded(child: TextField(controller: _dobCtrl, decoration: const InputDecoration(labelText: 'जन्म तिथि (DD/MM/YYYY)', border: OutlineInputBorder()))),
              const SizedBox(width: 8),
              Expanded(child: TextField(controller: _timeCtrl, decoration: const InputDecoration(labelText: 'समय (HH:MM)', border: OutlineInputBorder()))),
            ],
          ),
          const SizedBox(height: 10),
          TextField(controller: _placeCtrl, decoration: const InputDecoration(labelText: 'जन्म स्थान (शहर)', border: OutlineInputBorder())),
          const SizedBox(height: 15),
          SizedBox(
            width: double.infinity,
            height: 48,
            child: ElevatedButton(
              style: ElevatedButton.styleFrom(backgroundColor: Colors.deepOrange),
              onPressed: _isProcessing ? null : _triggerScriptureAnalysis,
              child: _isProcessing
                  ? const CircularProgressIndicator(color: Colors.white)
                  : const Text('17+ ग्रंथों से सटीक फलित उत्पन्न करें', style: TextStyle(color: Colors.white, fontSize: 15)),
            ),
          ),
          if (_dataLoaded) ...[
            const SizedBox(height: 20),
            const Divider(color: Colors.amber),
            const Text('कारक, मारक एवं ग्रह स्थिति सारांश', style: TextStyle(fontSize: 16, fontWeight: FontWeight.bold, color: Colors.amber)),
            const SizedBox(height: 10),
            Card(
              child: Padding(
                padding: const EdgeInsets.all(12),
                child: Column(
                  crossAxisAlignment: CrossAxisAlignment.start,
                  children: const [
                    Text('• लग्न व लग्नेश: सिंह लग्न (सूर्य मजबूत, केंद्रस्थ)', style: TextStyle(color: Colors.greenAccent)),
                    SizedBox(height: 4),
                    Text('• मारक ग्रह: शनि एवं शुक्र (द्वितीयेश/मारकेश)', style: TextStyle(color: Colors.redAccent)),
                    SizedBox(height: 4),
                    Text('• स्वास्थ्य संकेत (जातक मार्तंड अनुसार): पित्त प्रकृति और नेत्र विकार से सावधानी।', style: TextStyle(fontSize: 13)),
                  ],
                ),
              ),
            ),
            const SizedBox(height: 15),
            const Text('12 भावों का श्लोक-सहित विस्तृत फलित', style: TextStyle(fontSize: 16, fontWeight: FontWeight.bold, color: Colors.amber)),
            const SizedBox(height: 10),
            _buildBhavaDetailCard(
              1, 
              'प्रथम भाव (तनु भाव)', 
              'बृहत् पराशर होरा शास्त्र', 
              'लग्नेशे केंद्रकोणस्थे शुभग्रहैर्युतेक्षिते। देहसौख्यं भवेत् पूर्णं...',
              'लग्न स्वामी की स्थिति उत्तम होने से जातक पराक्रमी और यशस्वी होगा।'
            ),
            _buildBhavaDetailCard(
              2, 
              'द्वितीय भाव (धन भाव)', 
              'फलदीपिका', 
              'द्वितीये शुभसंयुक्ते वाग्मी पंडितवान् भवेत्...',
              'वाणी में ओज और पैतृक संपत्ति का पूर्ण लाभ मिलेगा।'
            ),
          ]
        ],
      ),
    );
  }

  Widget _buildBhavaDetailCard(int num, String title, String granth, String shlok, String fal) {
    return Card(
      margin: const EdgeInsets.only(bottom: 12),
      child: Padding(
        padding: const EdgeInsets.all(12),
        child: Column(
          crossAxisAlignment: CrossAxisAlignment.start,
          children: [
            Text('भाव $num: $title', style: const TextStyle(fontWeight: FontWeight.bold, color: Colors.orangeAccent)),
            Text('ग्रंथ: $granth', style: const TextStyle(fontSize: 11, color: Colors.white70)),
            const SizedBox(height: 6),
            Container(
              padding: const EdgeInsets.all(8),
              decoration: BoxDecoration(color: Colors.black38, borderRadius: BorderRadius.circular(6)),
              child: Text(shlok, style: const TextStyle(color: Colors.amberAccent, fontStyle: FontStyle.italic)),
            ),
            const SizedBox(height: 6),
            Text('फलित: $fal', style: const TextStyle(fontSize: 13, color: Colors.lightGreenAccent)),
          ],
        ),
      ),
    );
  }
}

// 2. प्रश्न कुंडली इंजन स्क्रीन
class PrashnaKundliEngineScreen extends StatelessWidget {
  const PrashnaKundliEngineScreen({super.key});

  @override
  Widget build(BuildContext context) {
    return Padding(
      padding: const EdgeInsets.all(16),
      child: Column(
        crossAxisAlignment: CrossAxisAlignment.start,
        children: const [
          Text('प्रश्न मार्ग एवं षट्पंचाशिका आधारित प्रश्न कुंडली', style: TextStyle(fontSize: 16, fontWeight: FontWeight.bold, color: Colors.amber)),
          SizedBox(height: 10),
          TextField(maxLines: 3, decoration: InputDecoration(hintText: 'मन में प्रश्न सोचकर यहाँ लिखें...', border: OutlineInputBorder())),
          SizedBox(height: 12),
          SizedBox(width: double.infinity, child: ElevatedButton(onPressed: null, child: Text('तत्काल प्रश्न फलित देखें')))
        ],
      ),
    );
  }
}

// अन्य डमी मॉड्यूल्स
class GunMilanScreen extends StatelessWidget {
  const GunMilanScreen({super.key});
  @override
  Widget build(BuildContext context) => const Center(child: Text('36 गुण मिलान और नाड़ी दोष मॉड्यूल'));
}

class PanchangMuhuratScreen extends StatelessWidget {
  const PanchangMuhuratScreen({super.key});
  @override
  Widget build(BuildContext context) => const Center(child: Text('दैनिक पंचांग, चौघड़िया एवं राहुकाल'));
}

class DoshaRemediesScreen extends StatelessWidget {
  const DoshaRemediesScreen({super.key});
  @override
  Widget build(BuildContext context) => const Center(child: Text('मंगल, कालसर्प दोष और लाल किताब के उपाय'));
}

class AIAdvisorScreen extends StatelessWidget {
  const AIAdvisorScreen({super.key});
  @override
  Widget build(BuildContext context) => const Center(child: Text('AstroSage AI / Bhrigoo AI लाइव चैट असिस्टेंस'));
}
