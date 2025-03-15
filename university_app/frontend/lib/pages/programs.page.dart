import 'dart:convert';
import 'package:flutter/material.dart';
import 'package:http/http.dart' as http;

class Program {
  final int id;
  final String name;
  final String description;

  Program({
    required this.id, 
    required this.name, 
    required this.description,
  });

  factory Program.fromJson(Map<String, dynamic> json) {
    return Program(
      id: json['id'],
      name: json['name'],
      description: json['description'],
    );
  }
}

class ProgramsPage extends StatefulWidget {
  const ProgramsPage({Key? key}) : super(key: key);

  @override
  State<ProgramsPage> createState() => _ProgramsPageState();
}

class _ProgramsPageState extends State<ProgramsPage> {
  late Future<List<Program>> futurePrograms;

  @override
  void initState() {
    super.initState();
    futurePrograms = fetchPrograms();
  }

  Future<List<Program>> fetchPrograms() async {
    final response = await http.get(Uri.parse("http://localhost:8080/api/programs"));
    
    if (response.statusCode == 200) {
      return (jsonDecode(response.body) as List)
          .map((data) => Program.fromJson(data))
          .toList();
    } else {
      throw Exception('Failed to load programs');
    }
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: const Text('University Programs'),
      ),
      body: FutureBuilder<List<Program>>(
        future: futurePrograms,
        builder: (context, snapshot) {
          if (snapshot.hasData) {
            final programs = snapshot.data!;
            return ListView.builder(
              itemCount: programs.length,
              itemBuilder: (context, index) {
                return Card(
                  margin: const EdgeInsets.all(10),
                  child: ListTile(
                    title: Text(
                      programs[index].name,
                      style: const TextStyle(fontWeight: FontWeight.bold),
                    ),
                    subtitle: Text(programs[index].description),
                    onTap: () {
                      // You can add navigation to a detail page here
                    },
                  ),
                );
              },
            );
          } else if (snapshot.hasError) {
            return Center(
              child: Text('Error: ${snapshot.error}'),
            );
          }
          
          // By default, show a loading spinner
          return const Center(
            child: CircularProgressIndicator(),
          );
        },
      ),
    );
  }
}