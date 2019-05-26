import { Component, OnInit } from '@angular/core';
import { AdminService } from 'src/app/services/admin.service';

@Component({
  selector: 'app-airadmin-table',
  templateUrl: './airadmin-table.component.html',
  styleUrls: ['./airadmin-table.component.css']
})
export class AiradminTableComponent implements OnInit {

  admins: any;

  constructor(private adminService: AdminService) { }

  ngOnInit() {
    this.loadAllAdmins();
  }

  loadAllAdmins() {
    this.adminService.getAirAdmins().subscribe(
      data => {
        this.admins = data;
      }
    )
  }

}
