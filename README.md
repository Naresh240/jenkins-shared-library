# jenkins-shared-library

## Pre-Requisites:

1. Install Git
2. Install Maven
3. Install Docker
4. Install Trivy
5. Add jacoco Plugin
6. Add Sonar Scanner Plugin and Integrate with Jenkins

## Installations:

```sh
## Git Installation
yum install git -y

## Maven Installation
yum install maven -y

## Docker Installation
yum install docker -y
service docker start

## Trivy Installation
vi /etc/yum.repos.d/trivy.repo
--------------------------------------------------------------------------
[trivy]
name=Trivy repository
baseurl=https://aquasecurity.github.io/trivy-repo/rpm/releases/$basearch/
gpgcheck=1
enabled=1
gpgkey=https://aquasecurity.github.io/trivy-repo/rpm/public.key
--------------------------------------------------------------------------

yum install trivy -y
```
