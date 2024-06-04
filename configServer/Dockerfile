FROM maven:3.8.3-openjdk-17
WORKDIR /app
COPY . /app/
RUN mvn clean package -DskipTests
ENV SPRING_CLOUD_CONFIG_SERVER_GIT_URI=https://github.com/atkaksoy501/turkcell-crm-config-server
CMD ["mvn","spring-boot:run"]