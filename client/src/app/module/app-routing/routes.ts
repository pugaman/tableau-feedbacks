import {Routes} from "@angular/router";
import {ReportComponent} from "../../component/report/report.component";
import {SettingsComponent} from "../../component/settings/settings.component";

/**
 * Created by pgolovenkov on 31.03.17.
 */
export const routes: Routes = [
  {
    path: '',
    redirectTo: '/report',
    pathMatch: 'full'
  },
  {
    path: 'report',
    component: ReportComponent
  },
  {
    path: 'settings',
    component: SettingsComponent
  }
];
