
<%@include file = "./allcomponents/allcss.jsp"%>
<!-- HTML structure remains unchanged -->
<html class="h-full bg-white ">
  <body class="h-full">
<div class="min-h-full">
  <nav class="bg-gray-800">
    <div class="mx-auto max-w-7xl px-4 sm:px-6 lg:px-8">
      <div class="flex h-16 items-center justify-between">
        <div class="flex items-center">
          <div class="flex-shrink-0">
            <a href ="index.jsp"><img class="h-8 w-8" src="https://tailwindui.com/img/logos/mark.svg?color=indigo&shade=500" alt="Your Company"></a>
          </div>
          <div class="hidden md:block">
            <div class="ml-10 flex items-baseline space-x-4">
              <a href="#" class="rounded-md bg-gray-900 px-3 py-2 text-sm font-medium text-white" aria-current="page">Dashboard</a>
              <a href="#" class="rounded-md px-3 py-2 text-sm font-medium text-gray-300 hover:bg-gray-700 hover:text-white">Team</a>
              <a href="#" class="rounded-md px-3 py-2 text-sm font-medium text-gray-300 hover:bg-gray-700 hover:text-white">Projects</a>
              <a href="#" class="rounded-md px-3 py-2 text-sm font-medium text-gray-300 hover:bg-gray-700 hover:text-white">Calendar</a>
              <a href="#" class="rounded-md px-3 py-2 text-sm font-medium text-gray-300 hover:bg-gray-700 hover:text-white">Reports</a>
            </div>
          </div>
        </div>
        <div class="hidden md:block">
          <div class="ml-4 flex items-center md:ml-6">
            <button type="button" class="relative rounded-full bg-gray-800 p-1 text-gray-400 hover:text-white focus:outline-none focus:ring-2 focus:ring-white focus:ring-offset-2 focus:ring-offset-gray-800">
              <span class="absolute -inset-1.5"></span>
              <span class="sr-only">View notifications</span>
              <svg class="h-6 w-6" fill="none" viewBox="0 0 24 24" stroke-width="1.5" stroke="currentColor" aria-hidden="true">
                <path stroke-linecap="round" stroke-linejoin="round" d="M14.857 17.082a23.848 23.848 0 005.454-1.31A8.967 8.967 0 0118 9.75v-.7V9A6 6 0 006 9v.75a8.967 8.967 0 01-2.312 6.022c1.733.64 3.56 1.085 5.455 1.31m5.714 0a24.255 24.255 0 01-5.714 0m5.714 0a3 3 0 11-5.714 0" />
              </svg>
            </button>

            <!-- Profile dropdown -->
            <div class="relative ml-3">
              <div>
                <button type="button" class="relative flex max-w-xs items-center rounded-full bg-gray-800 text-sm focus:outline-none focus:ring-2 focus:ring-white focus:ring-offset-2 focus:ring-offset-gray-800" id="user-menu-button" aria-expanded="false" aria-haspopup="true">
                  <span class="absolute -inset-1.5"></span>
                  <span class="sr-only">Open user menu</span>
                  <img class="h-8 w-8 rounded-full" src="https://images.unsplash.com/photo-1472099645785-5658abf4ff4e?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=facearea&facepad=2&w=256&h=256&q=80" alt="">
                </button>
              </div>

              <div id="dropdown-menu" class="absolute right-0 z-10 mt-2 w-48 origin-top-right rounded-md bg-white py-1 shadow-lg ring-1 ring-black ring-opacity-5 focus:outline-none hidden" role="menu" aria-orientation="vertical" aria-labelledby="user-menu-button" tabindex="-1">
                <a href="#" class="block px-4 py-2 text-sm text-gray-700" role="menuitem" tabindex="-1" id="user-menu-item-0">Your Profile</a>
                <a href="#" class="block px-4 py-2 text-sm text-gray-700" role="menuitem" tabindex="-1" id="user-menu-item-1">Settings</a>
                <a href="#" class="block px-4 py-2 text-sm text-gray-700" role="menuitem" tabindex="-1" id="user-menu-item-2">Sign out</a>
              </div>
            </div>
          </div>
        </div>
        <div class="-mr-2 flex md:hidden">
          <button type="button" class="relative inline-flex items-center justify-center rounded-md bg-gray-800 p-2 text-gray-400 hover:bg-gray-700 hover:text-white focus:outline-none focus:ring-2 focus:ring-white focus:ring-offset-2 focus:ring-offset-gray-800" aria-controls="mobile-menu" aria-expanded="false">
            <span class="absolute -inset-0.5"></span>
            <span class="sr-only">Open main menu</span>
            <svg class="block h-6 w-6" fill="none" viewBox="0 0 24 24" stroke-width="1.5" stroke="currentColor" aria-hidden="true">
              <path stroke-linecap="round" stroke-linejoin="round" d="M3.75 6.75h16.5M3.75 12h16.5m-16.5 5.25h16.5" />
            </svg>
            <svg class="hidden h-6 w-6" fill="none" viewBox="0 0 24 24" stroke-width="1.5" stroke="currentColor" aria-hidden="true">
              <path stroke-linecap="round" stroke-linejoin="round" d="M6 18L18 6M6 6l12 12" />
            </svg>
          </button>
        </div>
      </div>
    </div>

  </nav>

  <header class="bg-white shadow">
    <div class="mx-auto max-w-7xl px-4 py-6 sm:px-6 lg:px-8">
      <h1 class="text-3xl font-bold tracking-tight text-gray-900 text-center">Welcome, ${userobj.fname} ${userobj.lname}</h1>
    </div>
  </header>
  <main>
    <div class="mx-auto max-w-7xl px-4 py-6 sm:px-6 lg:px-8">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>My Dashboard | CustomerWeb</title>
    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <style>
        .card {
            cursor: pointer;
            transition: transform 0.2s;
        }
        .card:hover {
            transform: scale(1.05);
        }
        .card h5 {
            text-align: center;
        }
    </style>
</head>

<div class="container mt-5">
    <div class="row">
        <!-- Box 1: View My Packages -->
        <div class="col-md-3">
            <div class="card text-white bg-primary mb-3" onclick="viewPackages()">
                <div class="card-body">
                    <h5 class="card-title">Add New Package</h5>
                </div>
            </div>
        </div>

        <!-- Box 2: View My Feedbacks -->
        <div class="col-md-3">
            <div class="card text-white bg-success mb-3" onclick="viewFeedbacks()">
                <div class="card-body">
                    <h5 class="card-title">View My Feedbacks</h5>
                </div>
            </div>
        </div>

        <!-- Box 3: View Other Section (Customizable) -->
        <div class="col-md-3">
            <div class="card text-white bg-warning mb-3" onclick="viewOtherSection()">
                <div class="card-body">
                    <h5 class="card-title">View My Packages</h5>
                </div>
            </div>
        </div>

        <!-- Box 4: Manage Account -->
        <div class="col-md-3">
            <div class="card text-white bg-danger mb-3" onclick="manageAccount()">
                <div class="card-body">
                    <h5 class="card-title">Manage Account</h5>
                </div>
            </div>
        </div>
    </div>
</div>

<!-- Bootstrap JS (optional, for better responsiveness) -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>

<script>
    function viewPackages() {
        alert('Navigating to My Packages');
        // redirect to the page 
         window.location.href = 'Mobile/Prepaid.jsp';
    }

    function viewFeedbacks() {
        alert('Navigating to My Feedbacks');
     // redirect to the page 
         window.location.href = 'Feedback.jsp';
    }

    function viewOtherSection() {
        alert('View My Packages');
     // redirect to the page 
        window.location.href = 'Packages/MyPackages.jsp';
    }

    function manageAccount() {
        alert('Navigating to Manage Account');
     // redirect to the page 
        // window.location.href = 'your-manage-account-url';
    }
</script>


    </div>
  </main>
</div>

    <%@include file = "./allcomponents/footer.jsp" %>
</body>
</html>
<script>

  const userMenuButton = document.getElementById('user-menu-button');
  const dropdownMenu = document.getElementById('dropdown-menu');

  userMenuButton.addEventListener('click', () => {
    const isOpen = dropdownMenu.classList.toggle('hidden');
    userMenuButton.setAttribute('aria-expanded', !isOpen);
  });

 
  window.addEventListener('click', (event) => {
    if (!userMenuButton.contains(event.target) && !dropdownMenu.contains(event.target)) {
      dropdownMenu.classList.add('hidden');
      userMenuButton.setAttribute('aria-expanded', 'false');
    }
  });
</script>
