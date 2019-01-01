from django.db import models
import pytz
from django.db import models
from django.contrib.auth.models import (
    BaseUserManager, AbstractBaseUser
)
from datetime import datetime


# Create your models here.
class MyUserManager(BaseUserManager):

    def create_user(self, email, password):
        if email is None:
            raise ValueError('邮箱不能为空！')
        user = self.model(email=self.normalize_email(email))
        user.set_password(password)
        user.save(self._db)
        return user


class MyUser(AbstractBaseUser):
    email = models.EmailField(max_length=100, unique=True)
    created_at = models.DateTimeField(default=datetime.now().replace(tzinfo=pytz.timezone('UTC')))

    objects = MyUserManager()

    USERNAME_FIELD = 'email'
    REQUIRED_FIELDS = ['created_at']


class Coach(models.Model):
    course = models.CharField(max_length=30)
    url = models.CharField(max_length=255, default="")
    coach_name = models.CharField(max_length=30)
    telNo = models.CharField(max_length=11)


class Course(models.Model):
    course_id = models.BigAutoField(primary_key=True)
    course_name = models.CharField(max_length=30)
    course_proflie = models.TextField(null=True)
