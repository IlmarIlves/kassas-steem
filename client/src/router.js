import { createRouter, createWebHistory } from 'vue-router';
import BakingListView from './components/BakingListView.vue';
import BakingDetailsView from './components/BakingDetailsView.vue';
import BakingStatisticsView from './components/BakingStatisticsView.vue';

const routes = [  
    {
      path: '/',
      name: 'BakingListView',
      component: BakingListView,
    },
    {
      path: '/details/:id',
      name: 'BakingDetailsView',
      component: BakingDetailsView,
      props: true, // Enable passing route parameters as props
  
    },
    {
      path: '/statistsics',
      name: 'BakingStatisticsView',
      component: BakingStatisticsView,
    },
  ];

const router = createRouter({
  history: createWebHistory(),
  routes,
});

export default router;
