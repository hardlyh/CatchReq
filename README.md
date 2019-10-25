# CatchReq
SpringBoot 捕捉请求的小插件

### 使用方法

- 需要将项目下载导入的IDE,如果不需要发布的话直接install

- ```
  		<dependency>
    			<groupId>com.catchreq</groupId>
    			<artifactId>catch</artifactId>
    			<version>1.0.1</version>
    		</dependency>
  ```

- 配置filter新建配置类

- ```
  @Configuration
  @CatchReq
  public class CatchFilterDemo {
  	@Bean
  	@SuppressWarnings({ "rawtypes", "unchecked" })
  	public FilterRegistrationBean timerFilter() {
  		FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
  		filterRegistrationBean.setFilter(new CatrhReqFilter());
  		filterRegistrationBean.addUrlPatterns("/*");
  		return filterRegistrationBean;
  	}
  }
  ```

- 在主项目配置@ServletComponentScan注解

- 访问路径 http://xxx.xxx.xxx.xx:xxxx/reqCatch.html

### 界面演示

![演示](http://ww1.sinaimg.cn/large/006lAjRHly1g89aapfehbj31gq0nsdgf.jpg)