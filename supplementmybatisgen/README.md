# Mojo

maven自定义插件

创建maven项目时选择 `maven-archetype-mojo`

注意pom中引用的maven插件相关的包

`mvn install`打包之后，其他项目引入plugin即可

其他项目引入举例：

```xml
    <build>
        <plugins>
            <plugin>
                <groupId>com.sauzny</groupId>
                <artifactId>supplementmybatisgen</artifactId>
                <version>1.0-SNAPSHOT</version>
                <configuration>
                    <flag>all</flag>
                    <objectNames>
                        <objectName>User</objectName>
                        <objectName>Role</objectName>
                        <objectName>Food</objectName>
                        <objectName>Bill</objectName>
                    </objectNames>
                </configuration>
                <executions>
                    <execution>
                        <phase>package</phase>
                        <goals>
                            <goal>drive</goal>
                        </goals>
                    </execution>
                </executions>
            </plugin>
        </plugins>
    </build>
```