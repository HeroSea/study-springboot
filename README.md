## 怎么使用spring-loaded
参考文档: http://my.oschina.net/u/563848/blog/522548

1. 首先配置maven plugin
```
<plugin>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-maven-plugin</artifactId>
    <dependencies>
        <dependency>
            <groupId>org.springframework</groupId>
            <artifactId>springloaded</artifactId>
            <version>1.2.6.RELEASE</version>
        </dependency>
    </dependencies>
</plugin>
```
2. 在IDE里面运行spring-boot:run
[INFO] Attaching agents: [**/1.2.4.RELEASE/springloaded-1.2.4.RELEASE.jar]
   如果你能在控制台上看到这条日志说明spring-loaded已经加载了，按道理就是可以正常work了。
3. 提示
     如果你用的IDE是Eclipse，那以上配置就没问题了，如果你用的是IntelliJ IDEA，这里你需要注意一个问题：
     IntelliJ IDEA 是不会自动编译project的，所以，你会发现，你修改了java code，也Ctril+S了，但是Spring-Loaded就是没生效。既然知道原因，那我们就只要触发一下编译行为即可。
     你可以直接快捷键触发：   Ctrl+Shift+F9

     为了方便，最好设置成保存的时候就自动编译，方法可能有许多，我这里采用的是Macros方式来做的：

     1. Edit -> Macros -> Start Macro Recording
     2. Click File -> Save All
     3. Cilck Build -> Make Project
     4. Edit -> Macros -> Stop Macro Recording

     保存你录制的Macro，例如叫SaveAndMake

     接下来，为了能够在Ctrl+S的时候不仅保存还触发编译，我们先remove原有的keymap，修改SaveAndMake的快捷键为Ctrl+S。[提示:设置快捷键时同时按]