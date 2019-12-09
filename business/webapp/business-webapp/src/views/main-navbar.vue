<template>
  <nav class="site-navbar" :class="'site-navbar--' + navbarLayoutType">
    <div class="site-navbar__header">
      <h1 class="site-navbar__brand" @click="$router.push({ name: 'home' })">
        <a class="site-navbar__brand-lg" href="javascript:;">样例系统</a>
        <a class="site-navbar__brand-mini" href="javascript:;">样例</a>
      </h1>
    </div>
    <div class="site-navbar__body clearfix">
      <el-menu
        class="site-navbar__menu"
        mode="horizontal">
        <el-menu-item class="site-navbar__switch" index="0" @click="sidebarFold = !sidebarFold">
          <icon-svg name="zhedie"></icon-svg>
        </el-menu-item>
      </el-menu>
      <el-menu
        class="site-navbar__menu site-navbar__menu--right"
        mode="horizontal">
        <el-menu-item index="1" @click="$router.push({ name: 'theme' })">
          <template slot="title">
            <icon-svg name="shezhi" class="el-icon-setting"></icon-svg>
          </template>
        </el-menu-item>
        <el-menu-item index="2">
          <a href="//localhost:20001/swagger-ui.html" target="_blank">接口说明</a>
        </el-menu-item>
        <el-submenu index="3">
          <template slot="title">产品</template>
          <el-menu-item index="2-1"><a href="//www/" target="_blank">百度</a></el-menu-item>
        </el-submenu>
        <el-menu-item class="site-navbar__avatar" index="3">
          <el-dropdown :show-timeout="0" placement="bottom">
            <span class="el-dropdown-link">
              <img src="~@/assets/img/tx.png" :alt="userName">{{ userName }}
            </span>
<!--            <el-dropdown-menu slot="dropdown">-->
<!--              <el-dropdown-item @click.native="toUc()">用户中心</el-dropdown-item>-->
<!--              <el-dropdown-item @click.native="logoutHandle()">退出</el-dropdown-item>-->
<!--            </el-dropdown-menu>-->
          </el-dropdown>
        </el-menu-item>
      </el-menu>
    </div>
  </nav>
</template>

<script>
  import { clearLoginInfo } from '@/utils'
  export default {
    data () {
      return {
        updatePassowrdVisible: false
      }
    },
    computed: {
      navbarLayoutType: {
        get () { return this.$store.state.common.navbarLayoutType }
      },
      sidebarFold: {
        get () { return this.$store.state.common.sidebarFold },
        set (val) { this.$store.commit('common/updateSidebarFold', val) }
      },
      mainTabs: {
        get () { return this.$store.state.common.mainTabs },
        set (val) { this.$store.commit('common/updateMainTabs', val) }
      },
      userName: {
        get () { return this.$store.state.user.name }
      }
    },
    methods: {
      toUc () {
        location.href = process.env.VUE_APP_AC_HTTP_SERVER
      },
      gotoLogin () {
        const httpLogin = process.env.VUE_APP_AC_HTTP_LOGIN
        let url = `${httpLogin}?redirect_url=${encodeURIComponent(location.href)}`
        location.href = url
      },
      // 退出
      logoutHandle () {
        this.$confirm(`确定进行[退出]操作?`, '提示', {
          confirmButtonText: '确定',
          cancelButtonText: '取消',
          type: 'warning'
        }).then(() => {
          this.gotoLogin()
        }).catch(() => {})
      }
    }
  }
</script>
