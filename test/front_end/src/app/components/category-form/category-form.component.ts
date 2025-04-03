import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router, RouterModule } from '@angular/router';
import { Category } from './../../models/category.model';
import { CategoryService } from './../../services/category.service';
import { FormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';

import { MatFormFieldModule } from '@angular/material/form-field';
import { MatInputModule } from '@angular/material/input';
import { MatButtonModule } from '@angular/material/button';

@Component({
  selector: 'app-category-form',
  standalone: true,
  imports: [
    CommonModule,
    FormsModule,
    RouterModule,
    MatFormFieldModule,
    MatInputModule,
    MatButtonModule
  ],
  templateUrl: './category-form.component.html'
})
export class CategoryFormComponent implements OnInit {

  category: Category = { name: '' };
  editMode = false;

  constructor(
    private route: ActivatedRoute,
    private router: Router,
    private categoryService: CategoryService
  ) { }

  ngOnInit(): void {
    const id = this.route.snapshot.paramMap.get('id');
    if (id) {
      this.editMode = true;
      this.categoryService.getById(+id).subscribe({
        next: data => this.category = data,
        error: err => console.error(err)
      });
    }
  }

  validateInfo(): boolean {
    if (!this.category.name || this.category.name.trim() === '') {
      alert('Category name cannot be empty.');
      return false;
    }
    return true;
  }

  save() {
    if (!this.validateInfo()) {
      return;
    }

    if (this.editMode && this.category.id) {
      this.categoryService.update(this.category.id, this.category).subscribe({
        next: () => {
          alert('Category updated!');
          this.router.navigate(['/categories']);
        },
        error: err => console.error(err)
      });
    } else {
      this.categoryService.create(this.category).subscribe({
        next: () => {
          alert('Category saved!');
          this.router.navigate(['/categories']);
        },
        error: err => console.error(err)
      });
    }
  }
}