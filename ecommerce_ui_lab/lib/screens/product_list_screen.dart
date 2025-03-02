import 'package:flutter/material.dart';
import 'package:provider/provider.dart';
import '../models/product.dart';
import '../providers/cart_provider.dart';
import 'product_detail_screen.dart';
import '../widgets/app_bottom_navigation.dart';

class ProductListScreen extends StatelessWidget {
  // Sample product data - in a real app, this would come from an API or database
  final List<Product> products = [
    Product(
      name: 'Wireless Headphones',
      price: 129.99,
      imageUrl: 'assets/images/headphones.jpg',
    ),
    Product(
      name: 'Smart Watch',
      price: 199.99,
      imageUrl: 'assets/images/smartwatch.jpg',
    ),
    Product(
      name: 'Bluetooth Speaker',
      price: 79.99,
      imageUrl: 'assets/images/speaker.jpg',
    ),
    Product(
      name: 'Laptop',
      price: 899.99,
      imageUrl: 'assets/images/laptop.jpg',
    ),
    Product(
      name: 'Smartphone',
      price: 699.99,
      imageUrl: 'assets/images/smartphone.jpg',
    ),
    Product(
      name: 'Tablet',
      price: 349.99,
      imageUrl: 'assets/images/tablet.jpg',
    ),
  ];

  ProductListScreen({super.key});

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: const Text('Shop Products'),
      ),
      body: Padding(
        padding: const EdgeInsets.all(8.0),
        child: GridView.builder(
          gridDelegate: const SliverGridDelegateWithFixedCrossAxisCount(
            crossAxisCount: 2,
            childAspectRatio: 0.75,
            crossAxisSpacing: 10,
            mainAxisSpacing: 10,
          ),
          itemCount: products.length,
          itemBuilder: (context, index) {
            final product = products[index];
            return _buildProductCard(context, product);
          },
        ),
      ),
      bottomNavigationBar: AppBottomNavigation(
        currentIndex: 1,
        onTap: (index) {
          if (index != 1) {
            // Only navigate if it's not the current screen
            switch (index) {
              case 0:
                Navigator.pushReplacementNamed(context, '/');
                break;
              case 2:
                Navigator.pushReplacementNamed(context, '/cart');
                break;
              case 3:
                ScaffoldMessenger.of(context).showSnackBar(
                  const SnackBar(content: Text('Profile feature coming soon!')),
                );
                break;
            }
          }
        },
      ),
    );
  }

  Widget _buildProductCard(BuildContext context, Product product) {
    final cartProvider = Provider.of<CartProvider>(context, listen: false);
    
    return InkWell(
      onTap: () {
        Navigator.push(
          context,
          MaterialPageRoute(
            builder: (context) => ProductDetailScreen(product: product),
          ),
        );
      },
      child: Card(
        elevation: 4.0,
        shape: RoundedRectangleBorder(
          borderRadius: BorderRadius.circular(10.0),
        ),
        child: Column(
          crossAxisAlignment: CrossAxisAlignment.start,
          children: [
            // Product image at the top of the card
            Expanded(
              child: ClipRRect(
                borderRadius: const BorderRadius.vertical(top: Radius.circular(10.0)),
                child: product.imageUrl.startsWith('assets/')
                  ? Image.asset(
                      product.imageUrl,
                      fit: BoxFit.cover,
                      width: double.infinity,
                      errorBuilder: (context, error, stackTrace) {
                        return Container(
                          color: Colors.grey[300],
                          child: const Center(child: Text('No Image')),
                        );
                      },
                    )
                  : Image.network(
                      product.imageUrl,
                      fit: BoxFit.cover,
                      width: double.infinity,
                      errorBuilder: (context, error, stackTrace) {
                        return Container(
                          color: Colors.grey[300],
                          child: const Center(child: Text('No Image')),
                        );
                      },
                    ),
              ),
            ),
            // Product details and buy button
            Padding(
              padding: const EdgeInsets.all(8.0),
              child: Column(
                crossAxisAlignment: CrossAxisAlignment.start,
                children: [
                  Text(
                    product.name,
                    style: const TextStyle(
                      fontWeight: FontWeight.bold,
                      fontSize: 16,
                    ),
                    maxLines: 1,
                    overflow: TextOverflow.ellipsis,
                  ),
                  const SizedBox(height: 4),
                  Text(
                    '\$${product.price.toStringAsFixed(2)}',
                    style: TextStyle(
                      color: Theme.of(context).primaryColor,
                      fontWeight: FontWeight.w500,
                    ),
                  ),
                  const SizedBox(height: 8),
                  SizedBox(
                    width: double.infinity,
                    child: ElevatedButton(
                      style: ElevatedButton.styleFrom(
                        padding: const EdgeInsets.symmetric(vertical: 8),
                      ),
                      onPressed: () {
                        // Use the provider to add item to cart
                        cartProvider.addItem(product);
                        
                        ScaffoldMessenger.of(context).showSnackBar(
                          SnackBar(
                            content: Text('${product.name} added to cart'),
                            duration: const Duration(seconds: 1),
                          ),
                        );
                      },
                      child: const Text('Buy'),
                    ),
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