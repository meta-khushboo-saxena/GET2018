import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { UserComponent }   from './user/user.component';
import { AddUserComponent }      from './add-user/add-user.component';
import { EditUserComponent }  from './edit-user/edit-user.component';
import { AuthGuard }  from './auth/auth.guard';

const routes: Routes = [
  { path: '', redirectTo: '/user', pathMatch: 'full' },
  { path: 'user', component: UserComponent },
  { path: 'addUser', component: AddUserComponent , canActivate:[AuthGuard]},
  { path: 'editUser/:id', component: EditUserComponent ,canActivate:[AuthGuard] }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
