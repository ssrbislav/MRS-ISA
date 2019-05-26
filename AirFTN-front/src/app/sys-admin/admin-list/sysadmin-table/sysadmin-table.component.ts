import { Component, OnInit } from '@angular/core';
import { AdminService } from 'src/app/services/admin.service';
import { AdminDTO } from 'src/app/model/admin.model';

@Component({
  selector: 'app-sysadmin-table',
  templateUrl: './sysadmin-table.component.html',
  styleUrls: ['./sysadmin-table.component.css']
})
export class SysadminTableComponent implements OnInit {

  admins: any;
  constructor(private adminService: AdminService) { }

  ngOnInit() {
    this.loadAllSysAdmins();
  }

  loadAllSysAdmins() {
    this.adminService.getSysAdmins().subscribe(
      data => {
        this.admins = data;
      }
    );
  }

}
