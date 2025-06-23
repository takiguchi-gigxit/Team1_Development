import { createRouter, createWebHistory } from 'vue-router'
import TopPage from '../views/TopPage.vue'

// スケジュール
import ScheduleCalendar from '../views/Schedule/ScheduleCalendar.vue'
import ScheduleDetail from '../views/Schedule/ScheduleDetail.vue'
import ScheduleEdit from '../views/Schedule/ScheduleEdit.vue'
import ScheduleAdd from '../views/Schedule/ScheduleAdd.vue'
import ScheduleOverview from '../views/Schedule/ScheduleOverview.vue'

// お知らせ
const NoticeView = () => import('../views/Notice/NoticeView.vue')
const NoticeDetailView = () => import('../views/Notice/NoticeDetailView.vue')
const NoticeAddView = () => import('../views/Notice/NoticeAddView.vue')

// 社員紹介
import InforList from '../views/Introduce/InforList.vue'
import InforDetail from '../views/Introduce/InforDetail.vue'
import InforEdit from '../views/Introduce/InforEdit.vue'

const routes = [
  // トップページ
  { path: '/', name: 'TopPage', component: TopPage },

  // スケジュール
  { path: '/overview', name: 'Overview', component: ScheduleOverview },
  { path: '/schedule/add', name: 'ScheduleAdd', component: ScheduleAdd },
  { path: '/schedule/:id/edit', name: 'ScheduleEdit', component: ScheduleEdit },
  { path: '/schedule/:id', name: 'ScheduleDetail', component: ScheduleDetail },
  { path: '/calendar/:userId', name: 'ScheduleCalendar', component: ScheduleCalendar },

  // お知らせ
  { path: '/notice', name: 'NoticeView', component: NoticeView },
  { path: '/detail', name: 'NoticeDetail', component: NoticeDetailView },
  { path: '/addnotice', name: 'NoticeAdd', component: NoticeAddView },

  // 社員紹介
  { path: '/introduce', name: 'IntroduceList', component: InforList },
  { path: '/introduce/detail/:id', name: 'IntroduceDetail', component: InforDetail },
  { path: '/introduce/edit/:id', name: 'Edit', component: InforEdit }
]

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes
})

export default router
