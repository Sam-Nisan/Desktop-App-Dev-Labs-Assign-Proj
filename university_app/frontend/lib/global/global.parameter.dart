import 'package:flutter/material.dart';
import 'package:my_app/pages/admission.page.dart';
import 'package:my_app/pages/ccit.page.dart';
import 'package:my_app/pages/gallery.page.dart';
import 'package:my_app/pages/home.page.dart';
import 'package:my_app/pages/research.page.dart';

class GlobalParameters {
  static final routes = {
    "/": (context) => HomePage(),
    "/ccit": (context) => CCITPage(),
    "/admission": (context) => AdmissionPage(),
    "/research": (context) => ResearchPage(),
    "/gallery": (context) => GalleryPage(),
  };
  static final menus = [
    {"title": "Home", "route": "/", "icon": Icon(Icons.home)},
    {"title": "Admission", "route": "/admission", "icon": Icon(Icons.school)},
    {"title": "CCIT", "route": "/ccit", "icon": Icon(Icons.memory)},
    {"title": "Research", "route": "/research", "icon": Icon(Icons.repeat)},
    {"title": "Gallery", "route": "/gallery", "icon": Icon(Icons.camera)}
  ];
}
