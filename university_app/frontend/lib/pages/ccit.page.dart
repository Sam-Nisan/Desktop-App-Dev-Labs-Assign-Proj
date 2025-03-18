import 'package:flutter/material.dart';
import 'package:my_app/widgets/mydrawer.widget.dart';

class CCITPage extends StatefulWidget {
  @override
  _CCITPageState createState() => _CCITPageState();
}

class _CCITPageState extends State<CCITPage> {
  int interestCount = 0;

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: const Text("CCIT College"),
        leading: Builder(
          builder: (BuildContext context) {
            return IconButton(
              icon: const Icon(Icons.school),
              onPressed: () {
                Scaffold.of(context).openDrawer();
              },
            );
          },
        ),
      ),
      drawer: MyDrawer(), // Add the drawer here
      body: SingleChildScrollView(
        child: Padding(
          padding: const EdgeInsets.all(16.0),
          child: Column(
            crossAxisAlignment: CrossAxisAlignment.start,
            children: [
              // Header Section
              Row(
                children: [
                  const Icon(Icons.computer, size: 40, color: Colors.blue),
                  const SizedBox(width: 12.0),
                  Expanded(
                    child: Text(
                      "College of Computing and Information Technology (CCIT)",
                      style: Theme.of(context).textTheme.headlineSmall?.copyWith(
                        fontWeight: FontWeight.bold,
                      ),
                    ),
                  ),
                ],
              ),
              const Divider(thickness: 1.5, height: 32.0),
              
              // Description Cards
              Card(
                elevation: 3,
                margin: const EdgeInsets.only(bottom: 16.0),
                child: Padding(
                  padding: const EdgeInsets.all(16.0),
                  child: Column(
                    crossAxisAlignment: CrossAxisAlignment.start,
                    children: [
                      const ListTile(
                        contentPadding: EdgeInsets.zero,
                        leading: Icon(Icons.info_outline, color: Colors.blue),
                        title: Text("About CCIT", style: TextStyle(fontWeight: FontWeight.bold)),
                      ),
                      Text(
                        "The CCIT is dedicated to providing high-quality education in computing and information technology. It offers a variety of programs designed to equip students with the skills necessary for the evolving tech industry.",
                        style: Theme.of(context).textTheme.bodyMedium,
                      ),
                    ],
                  ),
                ),
              ),
              
              Card(
                elevation: 3,
                margin: const EdgeInsets.only(bottom: 16.0),
                child: Padding(
                  padding: const EdgeInsets.all(16.0),
                  child: Column(
                    crossAxisAlignment: CrossAxisAlignment.start,
                    children: [
                      const ListTile(
                        contentPadding: EdgeInsets.zero,
                        leading: Icon(Icons.business, color: Colors.blue),
                        title: Text("Industry Partnerships", style: TextStyle(fontWeight: FontWeight.bold)),
                      ),
                      Text(
                        "With a strong emphasis on hands-on learning, CCIT collaborates with industry leaders to ensure students gain practical experience and are ready for the job market.",
                        style: Theme.of(context).textTheme.bodyMedium,
                      ),
                    ],
                  ),
                ),
              ),
              
              // Services Card
              Card(
                elevation: 3,
                margin: const EdgeInsets.only(bottom: 24.0),
                child: const Column(
                  children: [
                    ListTile(
                      leading: Icon(Icons.computer, color: Colors.blue),
                      title: Text("CCIT Services"),
                      subtitle: Text("IT Support, Research & Labs"),
                    ),
                    ListTile(
                      leading: Icon(Icons.school, color: Colors.blue),
                      title: Text("Academic Programs"),
                      subtitle: Text("Bachelor's, Master's, and PhD programs"),
                    ),
                    ListTile(
                      leading: Icon(Icons.science, color: Colors.blue),
                      title: Text("Research Facilities"),
                      subtitle: Text("State-of-the-art labs and equipment"),
                    ),
                  ],
                ),
              ),
              
              // Interest Section
              Container(
                width: double.infinity,
                padding: const EdgeInsets.all(16.0),
                decoration: BoxDecoration(
                  color: Colors.blue.shade50,
                  borderRadius: BorderRadius.circular(8.0),
                  border: Border.all(color: Colors.blue.shade200),
                ),
                child: Column(
                  children: [
                    Row(
                      mainAxisAlignment: MainAxisAlignment.center,
                      children: [
                        const Icon(Icons.people, color: Colors.blue),
                        const SizedBox(width: 8.0),
                        Text(
                          "Number of interested students: $interestCount",
                          style: Theme.of(context)
                              .textTheme
                              .titleMedium
                              ?.copyWith(color: Colors.blue, fontWeight: FontWeight.bold),
                        ),
                      ],
                    ),
                    const SizedBox(height: 12.0),
                    ElevatedButton.icon(
                      onPressed: () {
                        setState(() {
                          interestCount++;
                        });
                      },
                      icon: const Icon(Icons.thumb_up),
                      label: const Text("Express Interest to Enroll"),
                      style: ElevatedButton.styleFrom(
                        padding: const EdgeInsets.symmetric(horizontal: 24, vertical: 12),
                      ),
                    ),
                  ],
                ),
              ),
            ],
          ),
        ),
      ),
    );
  }
}
