import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatInputModule } from '@angular/material/input';
import { MatButtonModule } from '@angular/material/button';
import { RouterModule, ActivatedRoute, Router } from '@angular/router';
import { ProductService } from './../../services/product.service';
import { Product } from './../../models/product.model';

@Component({
  selector: 'app-product-form',
  standalone: true,
  imports: [
    CommonModule,
    FormsModule,
    RouterModule,
    MatFormFieldModule,
    MatInputModule,
    MatButtonModule
  ],
  templateUrl: './product-form.component.html'
})
export class ProductFormComponent implements OnInit {

  product: Product = {
    name: '',
    description: '',
    price: 0,
    quantityInStock: 0
  };
  editMode = false;

  constructor(
    private route: ActivatedRoute,
    private router: Router,
    private productService: ProductService
  ) {}

  ngOnInit(): void {
    const id = this.route.snapshot.paramMap.get('id');
    if (id) {
      this.editMode = true;
      this.productService.getById(+id).subscribe({
        next: data => this.product = data,
        error: err => console.error(err)
      });
    }
  }

  save() {
    if (!this.validateInfos()) {
      return;
    }

    if (this.editMode && this.product.id) {
      this.productService.update(this.product.id, this.product).subscribe({
        next: () => {
          alert('Product updated!');
          this.router.navigate(['/']);
        },
        error: err => console.error(err)
      });
    } else {
      this.productService.create(this.product).subscribe({
        next: () => {
          alert('Product saved!');
          this.router.navigate(['/']);
        },
        error: err => console.error(err)
      });
    }
  }

  validateInfos(): boolean {
    if (!this.product.name || this.product.name.trim() === '') {
      alert('Product name cannot be empty.');
      return false;
    }

    if (this.product.quantityInStock <= 0) {
      alert('The stock must be greater than zero.');
      return false;
    }

    if (this.product.price <= 0) {
      alert('Price must be greater than zero.');
      return false;
    }

    return true;
  }
}