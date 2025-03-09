import 'package:flutter/material.dart';

class CCITPage extends StatefulWidget {
  @override
  _CCITPageState createState() => _CCITPageState();
}

class _CCITPageState extends State<CCITPage> {
  int interestCount = 0;

  @override
  Widget build(BuildContext context) {
    print("Widget render .............");
    return Scaffold(
      appBar: AppBar(
        title: Text("CCIT College"),
      ),
      body: Padding(
        padding: const EdgeInsets.all(16.0),
        child: Column(
          mainAxisAlignment: MainAxisAlignment.center,
          crossAxisAlignment: CrossAxisAlignment.start,
          children: [
            Text(
              "College of Computing and Information Technology (CCIT)",
              style: Theme.of(context).textTheme.headlineSmall,
            ),
            SizedBox(height: 16.0),
            Text(
              "The CCIT is dedicated to providing high-quality education in computing and information technology. It offers a variety of programs designed to equip students with the skills necessary for the evolving tech industry.",
              style: Theme.of(context).textTheme.bodyMedium,
            ),
            SizedBox(height: 16.0),
            Text(
              "With a strong emphasis on hands-on learning, CCIT collaborates with industry leaders to ensure students gain practical experience and are ready for the job market.",
              style: Theme.of(context).textTheme.bodyMedium,
            ),
            SizedBox(height: 20.0),
            Center(
              child: Column(
                children: [
                  Text(
                    "Number of interested students: $interestCount",
                    style: Theme.of(context)
                        .textTheme
                        .headlineSmall
                        ?.copyWith(color: Colors.blue),
                  ),
                  SizedBox(height: 10.0),
                  ElevatedButton(
                    onPressed: () {
                      setState(() {
                        interestCount++;
                      });
                    },
                    child: Text("Express Interest to Enroll"),
                  ),
                ],
              ),
            ),
          ],
        ),
      ),
    );
  }
}
