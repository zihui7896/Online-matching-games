import {createRouter, createWebHistory} from 'vue-router'

import PkIndexView from '@/views/pk/PkIndexView'
import PkIndexViewAl from '@/views/pk/PkIndexViewAl'
import NotFound from '@/views/error/NotFound'
import RanklistIndexView from '@/views/ranklist/RanklistIndexView'
import RecordContentView from '@/views/record/RecordContentView'
import RecordIndexView from '@/views/record/RecordIndexView'
import UserBotIndexView from '@/views/user/bot/UserBotIndexView'
import UserAccountLoginView from '@/views/user/account/UserAccountLoginView'
import UserAccountRegisterView from '@/views/user/account/UserAccountRegisterView'
import store from '@/store/index'

const routes = [
    {
        path: "/pk/",
        name: "home",
        redirect: "/kob/pk/",
        meta: {
            requestAuth: true,
        }
    },
    {
        path: "/kob/pk/al",
        name: "pk_index_al",
        component: PkIndexViewAl,
        meta: {
            requestAuth: true,
        }
    },
    {
        path: "/kob/pk/",
        name: "pk_index",
        component: PkIndexView,
        meta: {
            requestAuth: true,
        }
    },
    {
        path: "/kob/record/",
        name: "record_index",
        component: RecordIndexView,
        meta: {
            requestAuth: true,
        }
    },
    {
        path: "/kob/record/:recordId/",
        name: "record_content",
        component: RecordContentView,
        meta: {
            requestAuth: true,
        }
    },
    {
        path: "/kob/ranklist/",
        name: "ranklist_index",
        component: RanklistIndexView,
        meta: {
            requestAuth: true,
        }

    },
    {
        path: "/kob/user/bot/",
        name: "user_bot_index",
        component: UserBotIndexView,
        meta: {
            requestAuth: true,
        }
    },
    {
        path: "/kob/user/account/login/",
        name: "user_account_login",
        component: UserAccountLoginView,
        meta: {
            requestAuth: false,
        }
    },
    {
        path: "/kob/user/account/register/",
        name: "user_account_register",
        component: UserAccountRegisterView,
        meta: {
            requestAuth: false,
        }
    },
    {
        path: "/404/",
        name: "404",
        component: NotFound,
        meta: {
            requestAuth: false,
        }
    },
    {
        path: "/:catchAll(.*)",
        redirect: "/404/"
    }
]

const router = createRouter({
    history: createWebHistory(),
    routes
})

router.beforeEach((to, from, next) => {
    if (to.meta.requestAuth && !store.state.user.is_login) {
        next({name: "user_account_login"});
    } else {
        next();
    }
})

export default router
