import 'package:flutter/material.dart';
import 'package:my_app/widgets/mydrawer.widget.dart';

class HomePage extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      drawer: MyDrawer(),
      appBar: AppBar(
        title: Text("Home"),
      ),
      body: Padding(
        padding: const EdgeInsets.all(16.0),
        child: Column(
          mainAxisAlignment: MainAxisAlignment.center,
          crossAxisAlignment: CrossAxisAlignment.start,
          children: [
            Text(
              "University of Doha for Science and Technology (UDST)",
              style: Theme.of(context).textTheme.headlineSmall,
            ),
            SizedBox(height: 16.0),
            Text(
              "UDST is a leading institution in Qatar, offering applied education in various disciplines, including engineering, business, and health sciences. The university is committed to providing hands-on training and industry-aligned curricula to equip students with practical skills for the job market.",
              style: Theme.of(context).textTheme.bodyMedium,
            ),
            SizedBox(height: 16.0),
            Text(
              "Located in Doha, UDST fosters innovation and research through state-of-the-art facilities and strong industry partnerships. With a focus on experiential learning, the university aims to develop highly skilled professionals who contribute to Qatar’s growing economy and global competitiveness.",
              style: Theme.of(context).textTheme.bodyMedium,
            ),
          ],
        ),
      ),
    );
  }
}
