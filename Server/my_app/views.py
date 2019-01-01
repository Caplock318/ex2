from .models import MyUser, Coach, Course
from django.http import JsonResponse
from django.shortcuts import HttpResponse, render, redirect
from django.contrib.auth import authenticate
# Create your views here.


def register(request):
    response = dict()
    if request.method == 'POST':
        data = request.POST
        if (data['email'] is not None) and (data['password'] is not None):
            if len(MyUser.objects.filter(email=data['email'])) == 0:
                MyUser.objects.create_user(email=data['email'], password=data['password'])
                response['code'] = 200
                response['message'] = 'Register Successfully!'
                response['data'] = []
                return JsonResponse(response)
            else:
                response['code'] = 404
                response['message'] = 'Register Failed!'
                response['data'] = []
                return JsonResponse(response, safe=False)
        else:
            response['code'] = 404
            response['message'] = 'Register Failed!'
            response['data'] = []
            return JsonResponse(response, safe=False)
    else:
        return JsonResponse({'code': 404, 'message': 'test OK'})


def login(request):
    response = dict()
    if request.method == 'POST':
        data = request.POST
        if (data['email'] is not None) and (data['password'] is not None):
            temp_user = authenticate(username=data['email'], password=data['password'])
            if temp_user is not None:
                request.session['email'] = data['email']
                response['code'] = 200
                response['message'] = 'Login Successfully!'
                response['data'] = []
                return JsonResponse(response)
            else:
                response['code'] = 404
                response['message'] = 'Login Failed!'
                response['data'] = [{'email': data['email']}]
                return JsonResponse(response)
    else:
        return JsonResponse({'message': 'test OK'})


def logout(request):
    response = dict()
    if request.method == 'POST':
        if request.session.get('email', None) is not None:
            del request.session['email']
            response['code'] = 200
            response['message'] = 'Logout Successfully!'
            response['data'] = []
            return JsonResponse(response)
        else:
            response['code'] = 404
            response['message'] = 'Logout Failed!'
            response['data'] = []
            return JsonResponse(response)
    else:
        return JsonResponse({'message': 'test OK'})


def coach_list(request):
    if request.method == 'POST':
        data = request.POST
        response = dict()
        if data['course'] is not None:
            temp = Coach.objects.filter(course=data['course'])
            coach = []
            for x in temp:
                pause = dict()
                pause['name'] = x.coach_name
                pause['telNo'] = x.telNo
                pause['url'] = x.url
                coach.append(pause)
            return get_json(coach, 200, "已刷新!")
        else:
            response['data'] = ''
            response['code'] = 404
            response['message'] = "无对应课程！"
            return JsonResponse(response, safe=False)
    else:
        return render(request, "register.html")



def course_content(request):
    if request.method == 'Post':
        data = request.POST
        response = dict()
        if data['course_name'] is not None:
            temp = Course.objects.get(course_name=data['course_name']).course_proflie
            return get_json(temp, 200, "flush successfully!")
        else:
            response['data'] = ''
            response['code'] = 404
            response['message'] = "无对应课程！"


def get_json(data, code, message):
    repos = {'data': data, 'code': code, 'message': message}
    return JsonResponse(repos, safe=False)





