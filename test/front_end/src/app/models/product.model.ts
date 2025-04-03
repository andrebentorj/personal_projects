import { Category } from "./category.model";

export interface Product {
  id?: number;
  name: string;
  description: string;
  price: number;
  quantityInStock: number;
  creationDate?: string;
  categories?: Category[];
}