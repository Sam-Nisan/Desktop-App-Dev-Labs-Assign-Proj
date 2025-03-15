import 'package:flutter/material.dart';
import 'package:my_app/global/global.parameter.dart';

void main() {
  runApp(MyApp());
}

class MyApp extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      routes: GlobalParameters.routes,
      theme: ThemeData(
          primarySwatch: Colors.blue,
          textTheme: TextTheme(
            bodyMedium: TextStyle(
                fontSize: 22, color: const Color.fromARGB(255, 34, 122, 255)),
          )),
    );
  }
}
