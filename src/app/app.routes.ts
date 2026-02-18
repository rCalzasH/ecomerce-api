import { Routes } from '@angular/router';
import { Inicio } from './pages/inicio/inicio';
import { LogIn } from './pages/log-in/log-in';
import { Register } from './pages/register/register';
import { Productos } from './pages/productos/productos';
export const routes: Routes = [
    { path: '', redirectTo: 'inicio', pathMatch: 'full' },
    { path: 'inicio', component: Inicio },
    { path: 'logIn', component: LogIn},
    { path: 'register', component: Register},
    { path: 'Productos', component: Productos},
];
